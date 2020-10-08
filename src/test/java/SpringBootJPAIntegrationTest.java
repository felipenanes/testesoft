import com.nanes.testesoft.TestesoftApplication;
import com.nanes.testesoft.WebSecurityConfig;
import com.nanes.testesoft.model.GenericEntityRepository;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestesoftApplication.class)
@ContextConfiguration(classes = {
        FilterChainProxy.class,
        WebSecurityConfig.class
})
public class SpringBootJPAIntegrationTest {

    @Autowired
    private GenericEntityRepository genericEntityRepository;

    /*@Test
    public void givenGenericEntityRepository_whenSaveAndRetreiveEntity_thenOK() {
        GenericEntity genericEntity = genericEntityRepository.save(new GenericEntity());
        Optional<GenericEntity> foundEntity = genericEntityRepository.findById(genericEntity.getId());

        assertNotNull(foundEntity);
        assertEquals(genericEntity.getValue(), foundEntity.<Object>map(GenericEntity::getValue).orElse(null));
    }*/
}