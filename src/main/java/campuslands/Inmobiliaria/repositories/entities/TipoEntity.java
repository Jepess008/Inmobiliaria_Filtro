package campuslands.Inmobiliaria.repositories.entities;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Tipo")
public class TipoEntity {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String nombre_tipo;

   @JoinColumn(name = "id_caracteristicas")
   @ManyToOne(fetch = FetchType.LAZY)
   private CaracteristicasEntity caracteristicas;
   
   @OneToOne(mappedBy = "tipo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private InmuebleEntity inmueble;

   
}
