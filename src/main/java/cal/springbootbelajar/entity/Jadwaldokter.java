package cal.springbootbelajar.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "jadwaldokter")
public class Jadwaldokter {
    @Id
    @Column(name = "jadwaldokter_id")
    private Long id;
    @Column(name = "jadwaldoktermain_id")
    private Integer jadwaldoktermainId;
    @Column(name = "hari_id")
    private Integer hariId;
    @Column(name = "jadwaldokter_tanggal", columnDefinition = "DATE")
    private LocalDate tanggal;
    @Column(name = "jadwaldokter_waktu_dari", columnDefinition = "TIME")
    private LocalTime waktuDari;
    @Column(name = "jadwaldokter_waktu_sampai", columnDefinition = "TIME")
    private LocalTime waktuSampai;
    @Column(name = "jadwaldokter_kuota")
    private Integer kuota;
    @Column(name = "jadwadokter_estimasiwaktu")
    private Integer estimasiwaktu;
    @Column(name = "jadwaldokter_libur")
    private Integer libur;
    @Column(name = "jadwaldokter_created_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime createdAt;
    @Column(name = "jadwaldokter_updated_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime updatedAt;
}
