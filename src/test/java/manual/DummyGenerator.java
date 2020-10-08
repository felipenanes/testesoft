package manual;

import com.nanes.testesoft.model.Person;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DummyGenerator {
    public Person generateDummyPerson() throws Exception {
        String date = "13/02/1989";
        Date birth = new SimpleDateFormat("dd/MM/yyyy").parse(date);
        Person pessoa = new Person();
        pessoa.setName("Rogerio");
        pessoa.setSex("Masculino");
        pessoa.setEmail("rogerio@gmail.com");
        pessoa.setBirthDate(birth);
        pessoa.setNationality("Brasileiro");
        pessoa.setNaturality("Recife");
        pessoa.setCpf("08018890498");
        return pessoa;
    }
}
