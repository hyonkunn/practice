package com.example.postview;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class PostControllerTest {

    @InjectMocks
    private PostController postController;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Mockito 초기화
    }

    @After
    public void tearDown() {
        // 테스트 후 정리 작업이 필요한 경우 여기에 작성
    }

    @Test
    public void testGetPosts() {
        // 목 객체가 반환할 데이터를 설정
        List<Post> mockPosts = Arrays.asList(
                new Post("Mock Post 1", "Mock Content 1"),
                new Post("Mock Post 2", "Mock Content 2")
        );

        // PostController 메소드가 목 데이터 반환하는지 테스트
        when(postController.getPosts()).thenReturn(mockPosts);

        // 실제 메소드 호출
        List<Post> result = postController.getPosts();

        // 검증
        assertEquals(2, result.size());
        assertEquals("Mock Post 1", result.get(0).getTitle());
        assertEquals("Mock Content 1", result.get(0).getContent());

        // 목 객체 호출 검증
        verify(postController, times(1)).getPosts();
    }
}
