package mil.nga.gisdevops;

import mil.nga.gisdevops.models.Parcel;
import mil.nga.gisdevops.repositories.ParcelRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Created by mikemenne on 12/29/17.
 */
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class ParcelControllerTest {

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private ParcelRepository parcelRepository;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void serverIsUpAndFunctioning() throws Exception {
        this.mockMvc.perform(get("/alive")).andDo(print()).andExpect(content().string("yes"));
    }

    @Test
    public void homePageDisplaysListOfLandParcels() throws Exception {
        this.mockMvc.perform(get("/parcels")).andDo(print()).andExpect(content().string(containsString("St. Louis Land Parcels")));
    }

    @Test
    public void parcelsAreListedOnTheHomePate() throws Exception {
        parcelRepository.save(new Parcel("Plot 1"));
        parcelRepository.save(new Parcel("Plot 2"));
        this.mockMvc.perform(get("/parcels")).andDo(print())
                .andExpect(content().string(containsString("Plot 1")))
                .andExpect(content().string(containsString("Plot 2")));
    }

}