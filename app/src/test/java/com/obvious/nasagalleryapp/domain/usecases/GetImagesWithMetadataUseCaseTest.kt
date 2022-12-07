package com.obvious.nasagalleryapp.domain.usecases

import android.util.Log
import com.obvious.nasagalleryapp.data.entities.NasaImageData
import com.obvious.nasagalleryapp.data.repositories.ImagesRepositoryImpl
import com.obvious.nasagalleryapp.data.sources.local.LocalDataSource
import com.obvious.nasagalleryapp.domain.repositories.ImagesRepository
import io.mockk.*
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalCoroutinesApi::class)
internal class GetImagesWithMetadataUseCaseTest {

    @MockK
    private lateinit var localDataSource: LocalDataSource

    private var dateTimeFormatter: DateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE
    private var dispatcher: TestDispatcher = StandardTestDispatcher()

    private lateinit var useCase: GetImagesWithMetadataUseCase
    private lateinit var repository: ImagesRepository

    @Before
    fun setUp() {
        Dispatchers.setMain(dispatcher)
        MockKAnnotations.init(this)

        mockkStatic(Log::class)
        every { Log.e(any(), any(), any()) } returns 0

        repository = spyk(ImagesRepositoryImpl(localDataSource, dispatcher, dateTimeFormatter))
        useCase = GetImagesWithMetadataUseCase(repository)
    }

    @After
    fun tearDown() {
        unmockkAll()
        Dispatchers.resetMain()
    }

    @Test
    fun `WHEN dataSource returns empty list THEN verify`() = runTest {
        // given
        every { localDataSource.getNasaImageList() } returns emptyList()
        // when
        val result = useCase.invoke()
        // then
        coVerify { repository.getImagesWithMetadata() }
        verify { localDataSource.getNasaImageList() }
        Assert.assertNotNull(result)
        Assert.assertEquals(0, result.size)
    }

    @Test
    fun `WHEN dataSource returns non-empty list THEN verify`() = runTest {
        // given
        val mockList = listOf(
            spyk(NasaImageData()),
            spyk(NasaImageData()),
            spyk(NasaImageData()),
        )
        every { localDataSource.getNasaImageList() } returns mockList
        // when
        val result = useCase.invoke()
        // then
        coVerify { repository.getImagesWithMetadata() }
        verify { localDataSource.getNasaImageList() }
        Assert.assertNotNull(result)
        Assert.assertEquals(mockList.size, result.size)
    }

    @Test
    fun `WHEN dataSource returns non-empty list THEN verify order`() = runTest {
        // given
        val mockList = listOf(
            spyk(NasaImageData(date = "2019-12-01")),
            spyk(NasaImageData(date = "2019-12-02")),
            spyk(NasaImageData(date = "2019-12-03")),
        )
        every { localDataSource.getNasaImageList() } returns mockList
        // when
        val result = useCase.invoke()
        // then
        coVerify { repository.getImagesWithMetadata() }
        verify { localDataSource.getNasaImageList() }
        Assert.assertNotNull(result)
        Assert.assertEquals("2019-12-03", result.first().date.toString())
    }

    @Test
    fun `WHEN dataSource throws error THEN verify`() = runTest {
        // given
        val exception = RuntimeException("Something bad happened!")
        every { localDataSource.getNasaImageList() } throws exception
        // when
        val result = useCase.invoke()
        // then
        coVerify { repository.getImagesWithMetadata() }
        verify { localDataSource.getNasaImageList() }
        Assert.assertNotNull(result)
        Assert.assertTrue(result.isEmpty())
    }
}