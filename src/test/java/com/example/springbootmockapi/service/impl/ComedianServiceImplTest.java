package com.example.springbootmockapi.service.impl;

import com.example.springbootmockapi.mapper.ComedianMapper;
import com.example.springbootmockapi.mapper.impl.ComedianMapperImpl;
import com.example.springbootmockapi.repository.ComedianRepository;
import com.example.springbootmockapi.service.ComedianService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

class ComedianServiceImplTest {

    @Mock
    private ComedianRepository comedianRepository;

    @Mock
    private ComedianMapperImpl comedianMapper;

    private ComedianServiceImpl underTest;
    private AutoCloseable autoCloseable;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new ComedianServiceImpl(comedianRepository, comedianMapper);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void getComedians() {
        //when
        underTest.getComedians();
        //then
        verify(comedianRepository).findAll();
    }

    @Test
    @Disabled
    void getAComedian() {
    }

    @Test
    @Disabled
    void createComedian() {
    }

    @Test
    @Disabled
    void updateComedian() {
    }

    @Test
    @Disabled
    void deleteComedian() {
    }
}