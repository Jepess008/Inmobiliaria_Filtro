package campuslands.Inmobiliaria.repositories.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Caracteristicas")

public class CaracteristicasEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tamaño_parcela;
    private String urbanizacion;
    private Integer habitaciones;
    private Integer baños;
    private Integer aseos;
    private Integer cocinas;
    private String especificas; 
    private Integer num_puertas;
    private String diagano;
    private String acondicionado;

    @OneToMany(mappedBy = "caracteristicas", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TipoEntity> tipos;
    
}
