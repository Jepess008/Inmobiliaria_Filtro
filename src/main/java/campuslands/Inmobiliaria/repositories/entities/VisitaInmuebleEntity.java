package campuslands.Inmobiliaria.repositories.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "visita_inmueble")
public class VisitaInmuebleEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "id_visita")
    @ManyToOne(fetch = FetchType.LAZY)
    private VisitaEntity visita;

    @JoinColumn(name = "id_inmueble")
    @ManyToOne(fetch = FetchType.LAZY)
    private InmuebleEntity inmueble;
}
