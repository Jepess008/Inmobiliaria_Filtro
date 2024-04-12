package campuslands.Inmobiliaria.repositories.entities;

import java.sql.Date;
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
@Table(name = "Visita")
public class VisitaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Estado;
    private Date fecha;
    private String hora;
    private String comentario;

    @JoinColumn(name = "id_cliente")
    @ManyToOne(fetch = FetchType.LAZY)
    private ClienteEntity cliente;

    @OneToMany(mappedBy = "visita", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<VisitaInmuebleEntity> visitaInmuebles;
    
}
