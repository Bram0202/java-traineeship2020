package dao;

import domain.Person;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static util.Util.h2;

public class PersonDaoIT {

    private final PersonDao dao = new PersonDao(h2());

    @Test
    void whenEmployeeIsInsertedItGetsAnId() {
        dao.insert(new Person("A", 18));
        assertThat(dao.selectAll("A")).allMatch(p -> p.getId() != null);
    }
}

