package campuslands.Inmobiliaria.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import campuslands.Inmobiliaria.repositories.entities.ClienteEntity;
import campuslands.Inmobiliaria.services.ClienteService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/clientes")
@AllArgsConstructor
public class ClienteController {
    
    private ClienteService clienteService;

     @GetMapping("/")
    public List<ClienteEntity>findAll(){
        return clienteService.findAll();
    }

     @GetMapping("{id}")
    public ResponseEntity<Map<String,Object>> findAllById(@PathVariable Long id) throws Exception{
        Map<String,Object> response=new HashMap<>();
        ClienteEntity cliente= clienteService.findById(id);

      /*   throw new Exception("No se encontro profesion"); */
          if(cliente!=null){
            response.put("cliente", cliente);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }else{
            response.put("mensaje", new String("No existe ningun cliente con ese id "));
            return new ResponseEntity<>(response,HttpStatus.NO_CONTENT);
        } 
    }

    @PostMapping("/")
    public ResponseEntity<Map<String, Object>> save(@Valid @RequestBody ClienteEntity cliente, BindingResult result) {

        ClienteEntity clienteNew = null;

        Map<String, Object> response = new HashMap<>();

        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err -> "El campo " + err.getField() + " " + err.getDefaultMessage())
                    .collect(Collectors.toList());
            response.put("errors", errors);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        try {

            clienteNew = clienteService.save(cliente);

        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        }

        response.put("mensaje", "El cliente ha sido creado con éxito");
        response.put("cliente", clienteNew);

        return new ResponseEntity<>(response, HttpStatus.OK);

    }


    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> update(@Valid @RequestBody ClienteEntity cliente, BindingResult result,
            @PathVariable Long id) {

        ClienteEntity clienteUpdate = null;

        Map<String, Object> response = new HashMap<>();

        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err -> "El campo " + err.getField() + " " + err.getDefaultMessage())
                    .collect(Collectors.toList());
            response.put("errors", errors);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        try {

            clienteUpdate = clienteService.update(id, cliente);

        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar el upate en la base de datos");
            response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        }

        response.put("mensaje", "El cliente ha sido actualizado con éxito");
        response.put("profesion", clienteUpdate);

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable Long id) {

        Map<String, Object> response = new HashMap<>();
        try {
            clienteService.delete(id);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El cliente se ha elimando con éxito");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }



}
