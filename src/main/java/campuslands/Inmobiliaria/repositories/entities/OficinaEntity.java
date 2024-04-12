package campuslands.Inmobiliaria.repositories.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Oficina")
public class OficinaEntity {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    private String direccion;

    @JoinColumn(name = "id_ciudad")
    @ManyToOne(fetch = FetchType.LAZY)
    private CiudadEntity ciudad;

    @OneToMany(mappedBy = "oficina", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<InmuebleEntity> inmuebles;

}
