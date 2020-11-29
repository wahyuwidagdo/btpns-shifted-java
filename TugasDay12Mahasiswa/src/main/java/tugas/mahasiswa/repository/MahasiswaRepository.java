package tugas.mahasiswa.repository;

//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tugas.mahasiswa.model.Detail;
import tugas.mahasiswa.model.Mahasiswa;

import java.util.List;

//@Repository
public interface MahasiswaRepository {

    int saveMahasiswa(Mahasiswa mahasiswa);
    int saveDetail(Detail detail, long idmhs);
    int updateMahasiswa(Mahasiswa mahasiswa);
    int updateDetail(Detail detail);
    int tambahAbsen(Long idmhs);
    List<Mahasiswa> findById(Long id);
    List<Mahasiswa> findAllMhs();
    List<Detail> findByIdDetail(Long idmhs);
    boolean isMahasiswaExist(Mahasiswa mahasiswa);
    boolean isDetailExist(Detail detail);
//    int deleteMahasiswa(Mahasiswa mahasiswa);
//    int deleteDetail(Detail detail);

}
