import com.johnathanmsmith.mvc.web.config.WebMVCConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Date:   6/5/13 / 9:05 AM
 * Author: Johnathan Mark Smith
 * Email:  john@johnathanmarksmith.com
 * <p/>
 * Comments:
 * <p/>
 * This class is going to be use for testing my Spring MVC Hello World Web App.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebMVCConfiguration.class})
@WebAppConfiguration
public class TestHelloWorldWeb
{
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup()
    {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void getHTML() throws Exception
    {
        /*
            This following code will do 'GET' to the web apps
            and check that the return view is "helloworld"
            and also that it has a attribute "user" to "JohnathanMarkSmith"

         */
        this.mockMvc.perform(get("/ask/JohnathanMarkSmith")
                .accept(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andExpect(view().name("helloworld"))
                .andExpect(MockMvcResultMatchers.model().attribute("user", "JohnathanMarkSmith"));


    }

    @Test
    public void getJSON() throws Exception
    {
        /*
            This following code will do 'GET' to the web apps
            and also that it has a attribute "user" to "JohnathanMarkSmith"

         */
        this.mockMvc.perform(get("/json/JohnathanMarkSmith")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user").value("Johnathan Mark Smith"));
    }
}
