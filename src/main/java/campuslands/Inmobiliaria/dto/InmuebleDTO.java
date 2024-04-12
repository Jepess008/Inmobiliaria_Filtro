package campuslands.Inmobiliaria.dto;

import com.fasterxml.jackson.annotation.JsonView;

import lombok.Data;

@Data
public class InmuebleDTO {
    
    @JsonView(InmuebleDTO.class)
    private Long id;
    @JsonView(InmuebleDTO.class)
    private String ref;
    @JsonView(InmuebleDTO.class)
    private String superficie;
    @JsonView(InmuebleDTO.class)
    private String direccion;
    @JsonView(InmuebleDTO.class)
    private String disponible;
    @JsonView(InmuebleDTO.class)
    private double precio;
    @JsonView(InmuebleDTO.class)
    private String llaves;
    
    private Long id_zona;
    @JsonView(InmuebleDTO.class)
    private String zona;
    private Long id_oficina;
    @JsonView(InmuebleDTO.class)
    private String oficina;
    @JsonView(InmuebleDTO.class)
    private String ciudad;
    private Long id_propietario;
    @JsonView(InmuebleDTO.class)
    private String nombre_propietario;
    private Long id_tipo;
    @JsonView(InmuebleDTO.class)
    private String tipo;
    @JsonView(InmuebleDTO.class)
    private String tamaño_parcela;
    @JsonView(InmuebleDTO.class)
    private String urbanizacion;
    @JsonView(InmuebleDTO.class)
    private Integer habitaciones;
    @JsonView(InmuebleDTO.class)
    private Integer baños;
    @JsonView(InmuebleDTO.class)
    private Integer aseos;
    @JsonView(InmuebleDTO.class)
    private Integer cocinas;
    @JsonView(InmuebleDTO.class)
    private String especificas;
    @JsonView(InmuebleDTO.class)
    private Integer num_puertas;
    @JsonView(InmuebleDTO.class)
    private String diagano;
    @JsonView(InmuebleDTO.class)
    private String acondicionado;




}
