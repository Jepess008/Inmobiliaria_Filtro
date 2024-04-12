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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Inmueble")
public class InmuebleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ref;
    private String superficie;
    private String direccion;
    private String disponible;
    private double precio;
    private String llaves;

    @JoinColumn(name = "id_propietario")
    @ManyToOne(fetch = FetchType.LAZY)
    private PropietarioEntity propietario;

    @JoinColumn(name = "id_zona")
    @ManyToOne(fetch = FetchType.LAZY)
    private ZonaEntity zona;

    @JoinColumn(name = "id_oficina")
    @ManyToOne(fetch = FetchType.LAZY)
    private OficinaEntity oficina;

    @JoinColumn(name = "id_tipo")
    @OneToOne(fetch = FetchType.LAZY)
    private TipoEntity tipo;

    @OneToMany(mappedBy = "inmueble", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<VisitaInmuebleEntity> visitas;
    

}
