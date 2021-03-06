package com.adrianjaylopez.webstore.controller;

import com.adrianjaylopez.webstore.config.AppConfig;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import javax.annotation.Resource;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


/**
* UploadController Tester, uses Mock to create a fake item for upload. This test not only deals with
* uploading but also the storage of the image in the database.
* @author Adrian J Lopez
* @since <pre>6/22/15</pre>
* @version 2.0
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class}, loader = SpringApplicationContextLoader.class)
@WebAppConfiguration
public class UploadControllerTest {

    //declarations
    private MockMvc mockMvc;
    private MockMultipartFile mockFile;
    @Resource
    private WebApplicationContext webApplicationContext;
    @InjectMocks
    private UploadController uploadController;

    /**
     * Initial setup, deals with initializing the objects needed for this test.
     * @throws Exception
     */
    @Before
public void before() throws Exception {
    MockitoAnnotations.initMocks(this);
    this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).dispatchOptions(true)
            .build();
    mockFile = new MockMultipartFile("image", "blahimage", "text/plain", "ewr43rewr34wrqfffsad".getBytes());
}

@After
public void after() throws Exception {
    mockMvc = null;
    mockFile = null;

}
@Test
public void testFileUpload() throws Exception {
    this.mockMvc
            .perform(fileUpload("/upload")
            .file(mockFile).param("viewOrder","1"))
            .andExpect(MockMvcResultMatchers.status().isOk());
}
}
