package tugas.mahasiswa.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tugas.mahasiswa.model.Detail;
import tugas.mahasiswa.model.Mahasiswa;
import tugas.mahasiswa.repository.JdbcMahasiswaRepository;
import tugas.mahasiswa.repository.MahasiswaRepository;
import tugas.mahasiswa.util.CustomErrorType;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RestApiController {
    public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

    @Autowired
    MahasiswaRepository mahasiswaRepository;

    // -------------------Retrieve All Mahasiswa--------------------------------------------

    @RequestMapping(value = "/mahasiswa/", method = RequestMethod.GET)
    public ResponseEntity<List<Mahasiswa>> listAllMhs() {
        List<Mahasiswa> mahasiswa = mahasiswaRepository.findAllMhs();
        if (mahasiswa.isEmpty()) {
            return new ResponseEntity<>(mahasiswa, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(mahasiswa, HttpStatus.OK);
    }

    // -------------------Retrieve Single Mahasiswa------------------------------------------

    @RequestMapping(value = "/mahasiswa/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getMahasiswa(@PathVariable("id") Long id) {
        logger.info("Fetching Mahasiswa with id {}", id);
        List<Mahasiswa> mahasiswa = mahasiswaRepository.findById(id);
        if (mahasiswa == null) {
            logger.error("Mahasiswa with id {} not found.", id);
            return new ResponseEntity<>(new CustomErrorType("Mahasiswa with id " + id  + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(mahasiswa, HttpStatus.OK);
    }

    // -------------------Retrieve Single Detail-------------------------------------------

    @RequestMapping(value = "/mahasiswa/{id}/detail", method = RequestMethod.GET)
    public ResponseEntity<?> detailNilaiMahasiswa(@PathVariable("id") Long id) {
        logger.info("Fetching Detail with id Mhs {}", id);
        List<Detail> detail = mahasiswaRepository.findByIdDetail(id);
        return new ResponseEntity<>(detail, HttpStatus.CREATED);
    }

    // -------------------Create a Mahasiswa-------------------------------------------

    @RequestMapping(value = "/mahasiswa/", method = RequestMethod.POST)
    public ResponseEntity<?> createMahasiswa(@RequestBody Mahasiswa mahasiswa) {
        logger.info("Creating Mahasiswa : {}", mahasiswa);
        if (mahasiswaRepository.isMahasiswaExist(mahasiswa)) {
            logger.error("Unable to create. A Mahasiswa with name {} already exist", mahasiswa.getFullname());
            return new ResponseEntity<>(new CustomErrorType("Unable to create. A Mahasiswa with name " +
                    mahasiswa.getFullname() + " already exist."), HttpStatus.CONFLICT);
        }
        mahasiswaRepository.saveMahasiswa(mahasiswa);


        return new ResponseEntity<>(mahasiswa, HttpStatus.CREATED);
    }

    // -------------------Create a Detail-------------------------------------------

    @RequestMapping(value = "/mahasiswa/{id}/adddetail", method = RequestMethod.POST)
    public ResponseEntity<?> createDetail(@PathVariable("id") Long id, @RequestBody Detail detail) {
        logger.info("Creating Mahasiswa : {}", detail);
        mahasiswaRepository.saveDetail(detail,id);
        return new ResponseEntity<>(detail, HttpStatus.CREATED);
    }

    // ------------------- Update a Mahasiswa ------------------------------------------------

    @RequestMapping(value = "/mahasiswa/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateMahasiswa(@PathVariable("id") Long id, @RequestBody Mahasiswa mahasiswa) {
        logger.info("Updating Mahasiswa with id {}", id);

        List<Mahasiswa> currentMahasiswa = mahasiswaRepository.findById(id);
        if (currentMahasiswa == null) {
            logger.error("Unable to update. Mahasiswa with id {} not found.", id);
            return new ResponseEntity<>(new CustomErrorType("Unable to update. Mahasiswa with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        for (Mahasiswa obj: currentMahasiswa ){
            obj.setFullname(mahasiswa.getFullname());
            obj.setStatus(mahasiswa.getStatus());
            mahasiswaRepository.updateMahasiswa(obj);
        }
        return new ResponseEntity<>(currentMahasiswa, HttpStatus.OK);
    }

    // ------------------- Update a Detail ------------------------------------------------

    @RequestMapping(value = "/mahasiswa/{id}/editdetail", method = RequestMethod.PUT)
    public ResponseEntity<?> updateDetail(@PathVariable("id") Long id, @RequestBody Detail detail) {
        logger.info("Updating Mahasiswa with id {}", id);

        List<Detail> currentDetail = mahasiswaRepository.findByIdDetail(id);
        if (currentDetail == null) {
            logger.error("Unable to update. Mahasiswa with id {} not found.", id);
            return new ResponseEntity<>(new CustomErrorType("Unable to upate. Mahasiswa with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        for (Detail obj: currentDetail ){
            obj.setPhysics(detail.getPhysics());
            obj.setCalculus(detail.getCalculus());
            obj.setBiologi(detail.getBiologi());
            mahasiswaRepository.updateDetail(obj);
        }

        return new ResponseEntity<>(currentDetail, HttpStatus.OK);
    }

    // ------------------- Tambah Absen ------------------------------------------------

    @RequestMapping(value = "/mahasiswa/{id}/tambahabsen", method = RequestMethod.PUT)
    public ResponseEntity<?> tambahAbsen(@PathVariable("id") Long id) {
        logger.info("Updating Mahasiswa with id {}", id);

        List<Mahasiswa> currentMahasiswa = mahasiswaRepository.findById(id);
        if (currentMahasiswa == null) {
            logger.error("Unable to update. Mahasiswa with id {} not found.", id);
            return new ResponseEntity<>(new CustomErrorType("Unable to update. Mahasiswa with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        mahasiswaRepository.tambahAbsen(id);

        return new ResponseEntity<>(mahasiswaRepository, HttpStatus.OK);
    }
}
