package com.start.repository;

import com.start.models.SuperObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.notNull;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

class SuperRepositoryTest {


        @Mock
        private SuperRepository<String> mockRepository;

        @Mock
        private SuperObject superObject;

        @BeforeEach
        void setup() {
            MockitoAnnotations.openMocks(this);
        }

        @Test
        void size() {
            when(mockRepository.size()).thenReturn(10);
            assertEquals(10, mockRepository.size());
        }

        @Test
        void isEmpty() {
            when(mockRepository.isEmpty()).thenReturn(true);
            assertTrue(mockRepository.isEmpty());
        }
    @Test
    void remove() {
        List<String> list = new ArrayList<>(Arrays.asList("Element 1", "Element 2", "Element 3"));
        doAnswer(invocation -> {
            list.remove(1);
            return null;
        }).when(mockRepository).remove(1);

        mockRepository.remove(1);

        assertEquals(2, list.size());
        assertFalse(list.contains("Element 2"));
    }



        @Test
        void checkId() {
            when(mockRepository.checkId(1)).thenReturn(true);
            assertTrue(mockRepository.checkId(1));
        }

        @Test
        void getAll() {
            List<String> expectedList = Arrays.asList("Element 1", "Element 2", "Element 3");
            when(mockRepository.getAll()).thenReturn(expectedList);

            List<String> actualList = mockRepository.getAll();

            assertEquals(expectedList, actualList);
        }

        @Test
        void getById() {
            when(mockRepository.getById(1)).thenReturn("Element 1");
            assertEquals("Element 1", mockRepository.getById(1));
        }


        @Test
        void findAll() {
            List<String> list = new ArrayList<>(Arrays.asList("Element 1", "Element 2", "Element 3"));
            when(mockRepository.findAll()).thenReturn(list.iterator());


            Iterator<String> iterator = mockRepository.findAll();

            assertTrue(iterator.hasNext());
            assertEquals("Element 1", iterator.next());
            assertTrue(iterator.hasNext());
            assertEquals("Element 2", iterator.next());
            assertTrue(iterator.hasNext());
            assertEquals("Element 3", iterator.next());
            assertFalse(iterator.hasNext());
        }
    }
