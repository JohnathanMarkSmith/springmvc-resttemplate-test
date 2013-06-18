###  Using Spring RESTTemplate to Post Objects to RESTful web services with Spring's Java Configuration (JavaConfig) style with Maven, JUnit, Log4J


In this example I am going to show you how to post data to a RESTful web service in Java using Spring, Spring Java Configuration and more


### Web Service Code

Let's take a quick look at the Spring MVC Web Service code on the server:

    @Controller
    @RequestMapping("/api")
    class JSonController
    {

        private static final Logger logger = LoggerFactory.getLogger(JSonController.class);



        @RequestMapping(value = "/{id}", method = RequestMethod.POST)
        @ResponseBody
        public User updateCustomer(@PathVariable("id") String id, @RequestBody User user) {

            logger.debug("I am in the controller and got ID: " + id.toString());
            logger.debug("I am in the controller and got user name: " + user.toString());

            return new User("NEW123", "NEW SMITH");
        }


As you can see from the code above the web service is goign to what for a ID and user object to be passed in and then its going to create a new User Object and send it back to the client.

### Time For The Client Code

You can see from the client code below is that we are using Spring RESTTemaple and going to post an User Object to a web server and get one back.


    @PropertySource("classpath:application.properties")
    public class Main
    {

        /**
         * Setting up logger
         */
        private static final Logger LOGGER = getLogger(Main.class);


        public static void main(String[] args) throws IOException
        {
            LOGGER.debug("Starting REST Client!!!!");

            /**
             *
             * This is going to setup the REST server configuration in the applicationContext
             * you can see that I am using the new Spring's Java Configuration style and not some OLD XML file
             *
             */
            ApplicationContext context = new AnnotationConfigApplicationContext(RESTConfiguration.class);

            /**
             *
             * We now get a RESTServer bean from the ApplicationContext which has all the data we need to
             * log into the REST service with.
             *
             */
            RESTServer mRESTServer = context.getBean(RESTServer.class);



            /**
             *
             * Setting up data to be sent to REST service
             *
             */
            Map<String, String> vars = new HashMap<String, String>();
            vars.put("name", "JohnathanMarkSmith");




            /**
             *
             * Doing the REST call and then displaying the data/user object
             *
             */


            try
            {

                /*

                    This is code to post and return a user object

                 */

                RestTemplate rt = new RestTemplate();
                rt.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
                rt.getMessageConverters().add(new StringHttpMessageConverter());

                URI uri = new URI("http://" + mRESTServer.getHost() + ":8080/springmvc-resttemplate-test/api/JMS");

                User u = new User();
                u.setName("Johnathan M Smith");
                u.setUser("JMS");


                User returns = rt.postForObject(uri, u, User.class);

                LOGGER.debug("User:  " + u.toString());

            }
            catch (HttpClientErrorException e)
            {
                /**
                 *
                 * If we get a HTTP Exception display the error message
                 */

                LOGGER.error("error:  " + e.getResponseBodyAsString());

                ObjectMapper mapper = new ObjectMapper();
                ErrorHolder eh = mapper.readValue(e.getResponseBodyAsString(), ErrorHolder.class);

                LOGGER.error("error:  " + eh.getErrorMessage());

            }
            catch(Exception e)
            {
                LOGGER.error("error:  " + e.getMessage());

            }
        }

    }


You can see from the above code how easy it is to use RESTTeample to post data to a web service.



You can see how easy it is to use Spring's Java Configuration (JavaConfig) style and Not XML.. The time of using XML files with Springs is over...

### We Can I Get The Sourcec Code

You can checkout the project from github.

    git clone git@github.com:JohnathanMarkSmith/springmvc-resttemplate-test.git
    cd springmvc-resttemplate-test.git


If you have any questions please email me at john@johnathanmarksmith.com