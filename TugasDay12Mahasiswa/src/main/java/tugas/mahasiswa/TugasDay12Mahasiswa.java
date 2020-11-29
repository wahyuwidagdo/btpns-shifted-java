package tugas.mahasiswa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import tugas.mahasiswa.model.Detail;
import tugas.mahasiswa.model.Mahasiswa;
import tugas.mahasiswa.repository.JdbcMahasiswaRepository;
import tugas.mahasiswa.repository.MahasiswaRepository;

@SpringBootApplication(scanBasePackages = {"tugas.mahasiswa"})
public class TugasDay12Mahasiswa implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(TugasDay12Mahasiswa.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    //@Qualifier("jdbcMahasiswaRepository")              // Test JdbcTemplate
    //@Qualifier("namedParameterJdbcBookRepository")  // Test NamedParameterJdbcTemplate
    public MahasiswaRepository mahasiswaRepository;

    public static void main(String[] args) {
        SpringApplication.run(TugasDay12Mahasiswa.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("StartApplication...");
        runJDBC();
    }

    private void runJDBC() {

        log.info("Creating tables for testing...");

        jdbcTemplate.execute("DROP TABLE IF EXISTS header");
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS header(" +
                "idmhs SERIAL, fullname VARCHAR(255), address VARCHAR(255), status VARCHAR(255), absensi INT(11))");

        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.setFullname("Soleh Said");
        mahasiswa.setAddress("Jakarta");
        mahasiswa.setStatus("Active");
        mahasiswa.setAbsensi(0);

        log.info("Saving...{}", mahasiswa.getFullname());
        int idmhs=mahasiswaRepository.saveMahasiswa(mahasiswa);
        System.out.println("Id Mahasiswa: "+idmhs);

        jdbcTemplate.execute("DROP TABLE IF EXISTS detail");
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS detail(" +
                "iddetail SERIAL, idmhs INT(11), fisika INT (11), calculus INT (11),biologi INT(11),idMhs INT(11))");

        Detail detail = new Detail();
        detail.setPhysics(80);
        detail.setCalculus(70);
        detail.setBiologi(85);
        detail.setIdmhs(idmhs);

        mahasiswaRepository.saveDetail(detail, idmhs);
    }
}