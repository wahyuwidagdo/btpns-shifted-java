package tugas.mahasiswa.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import tugas.mahasiswa.model.Detail;
import tugas.mahasiswa.model.Mahasiswa;

import java.util.List;

@Repository
public class JdbcMahasiswaRepository implements MahasiswaRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int saveMahasiswa(Mahasiswa mahasiswa) {
        return jdbcTemplate.update("INSERT INTO header(idmhs, fullname, address, status, absensi) values(?, ?, ?, ?, ?)",
        null, mahasiswa.getIdmhs(), mahasiswa.getFullname(), mahasiswa.getAddress(), mahasiswa.getStatus(), mahasiswa.getAbsensi());
    }

    @Override
    public int saveDetail(Detail detail, long idmhs) {
        return jdbcTemplate.update("INSERT INTO detail(iddetail, idmhs, physics, calculus, biologi) values(?, ?, ?, ?, ?)",
                null, idmhs, detail.getPhysics(), detail.getCalculus(), detail.getBiologi());
    }

    @Override
    public int updateMahasiswa(Mahasiswa mahasiswa) {
        return jdbcTemplate.update("UPDATE header set fullname = ?, status = ?, where idmhs = ?",
                mahasiswa.getFullname(), mahasiswa.getStatus(), mahasiswa.getIdmhs());
    }

    @Override
    public int updateDetail(Detail detail) {
        return jdbcTemplate.update("UPDATE detail set physics = ?, calculus = ?, biologi = ? where idmhs = ?",
                detail.getPhysics(), detail.getCalculus(), detail.getBiologi(), detail.getIdmhs());
    }

    @Override
    public int tambahAbsen(Long idmhs) {
        return jdbcTemplate.update("UPDATE header set absensi = absensi + 1 where idmhs = ?",
                idmhs);
    }

    @Override
    public List<Mahasiswa> findById(Long id) {
        return jdbcTemplate.query(
                "select * from header where idmhs="+id+"",
                (rs, rowNum) ->
                        new Mahasiswa(
                                rs.getLong("idmhs"),
                                rs.getString("fullname"),
                                rs.getString("address"),
                                rs.getString("status"),
                                rs.getInt("absensi")
                        )
        );
    }

    @Override
    public List<Mahasiswa> findAllMhs() {
        return jdbcTemplate.query(
                "select * from header",
                (rs, rowNum) ->
                        new Mahasiswa(
                                rs.getLong("idmhs"),
                                rs.getString("fullname"),
                                rs.getString("address"),
                                rs.getString("status"),
                                rs.getInt("absensi")
                        )
        );
    }

    @Override
    public List<Detail> findByIdDetail(Long idmhs) {
        return jdbcTemplate.query(
                "select * from detail where idmhs = "+idmhs+"",
                (rs, rowNum) ->
                        new Detail(
                                rs.getLong("iddetail"),
                                rs.getLong("idmhs"),
                                rs.getInt("physics"),
                                rs.getInt("calculus"),
                                rs.getInt("biologi")
                        )
        );
    }

    @Override
    public boolean isMahasiswaExist(Mahasiswa mahasiswa) {
        List<Mahasiswa> datMhs = jdbcTemplate.query(
                "Select * from detail where idmhs='"+mahasiswa.getIdmhs()+"'",
                new BeanPropertyRowMapper(Mahasiswa.class));

//        return customers;
//       jdbcTemplate.execute("Select * from header where fullName='"+mhs.getFullName()+"'");
        if (datMhs.size()!=0){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isDetailExist(Detail detail) {
        List<Detail> datMhs = jdbcTemplate.query(
                "Select * from detail where idmhs='"+detail.getIdmhs()+"'",
                new BeanPropertyRowMapper(Detail.class));

//        return customers;
        if (datMhs.size()!=0){
            return true;
        } else {
            return false;
        }
    }
}
