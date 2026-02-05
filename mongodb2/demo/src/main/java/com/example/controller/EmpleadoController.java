package com.example.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.example.model.Empleado;
import com.example.utils.MongoProvider;
import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;

/**
 * Controlador de empleados.
 */
public class EmpleadoController {
    /**
     * Crea un nuevo empleado en la base de datos.
     * 
     * @param numeroEmpleado número del empleado
     * @param nombre         nombre del empleado
     * @param dep            departamento del empleado
     * @param salario        salario del empleado
     * @param fechaalta      fecha de alta del empleado
     * @param oficio         oficio del empleado
     * @param comision       comision del empleado
     */
    public void crearEmpleado(int numeroEmpleado, String nombre, int dep, int salario, String fechaalta, String oficio,
            int comision) {
        Empleado empleado = new Empleado(numeroEmpleado, nombre, dep, salario, fechaalta, oficio, comision);
        try (MongoProvider mongo = new MongoProvider()) {
            MongoCollection<Document> collection = mongo.empleados();
            // La otra opcion es usando un objectMapper writeValueAsString
            Document insercion = Document.parse(new Gson().toJson(empleado));
            collection.insertOne(insercion);
            System.out.println("Empleado insertado correctamente");
        } catch (Exception e) {
            System.out.println("Algo ha salido muy mal");
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }
    }

    /**
     * Filtra empleados segun el filtro dado.
     * 
     * @param filtro filtro de la consulta. Si se usa Filters.empty() devuelve
     *               todos.
     * @return cadena con los empleados que cumplen el filtro separados por saltos
     *         de linea
     */
    public String filtrarEmpleados(Bson filtro) {
        StringBuilder resultado = new StringBuilder();
        try (MongoProvider mongo = new MongoProvider()) {
            MongoCollection<Document> collection = mongo.empleados();
            for (Document doc : collection.find(filtro)) {
                resultado.append(doc.toJson() + "\n");
            }
            System.out.println("La consulta fue exitosa");
        } catch (Exception e) {
            System.out.println("Algo ha salido muy mal y el valor a devolver es vacio");
            resultado = new StringBuilder();
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }
        return resultado.toString();
    }

    /**
     * Filtra empleados segun el filtro dado.
     * 
     * @param filtro filtro de la consulta. Si se usa Filters.empty() devuelve
     *               todos.
     * @return cadena con los empleados que cumplen el filtro separados por saltos
     *         de linea
     */
    public String filtrarEmpleadosAvanzados(Bson filtro) {
        return filtrarEmpleadosAvanzados(Arrays.asList(filtro));
    }

    /**
     * Filtra empleados segun los filtros dados.
     * @param filtros lista de filtros de la consulta.
     * @return cadena con los empleados que cumplen los filtros separados por saltos de linea
     */
    public String filtrarEmpleadosAvanzados(List<Bson> filtros) {
        StringBuilder resultado = new StringBuilder();
        try (MongoProvider mongo = new MongoProvider()) {
            MongoCollection<Document> collection = mongo.empleados();
            ArrayList<Document> resultados = collection.aggregate(filtros).into(new ArrayList<>());
            for (Document doc : resultados) {
                resultado.append(doc.toJson() + "\n");
            }
            System.out.println("La consulta fue exitosa");
        } catch (Exception e) {
            System.out.println("Algo ha salido muy mal y el valor a devolver es vacio");
            resultado = new StringBuilder();
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }
        return resultado.toString();
    }

    /**
     * Actualiza los empleados que cumplen el filtro con la actualizacion dada.
     * 
     * @param filtro        filtro de seleccion de empleados a actualizar
     * @param actualizacion actualizacion a aplicar a los empleados seleccionados
     */
    public void actualizarEmpleados(Bson filtro, Bson actualizacion) {
        try (MongoProvider mongo = new MongoProvider()) {
            MongoCollection<Document> collection = mongo.empleados();
            long cambiadas = collection.updateMany(filtro, actualizacion).getModifiedCount();
            System.out.println("Actualizacion realizada con exito. Se han modificado " + cambiadas + " entradas.");

        } catch (Exception e) {
            System.out.println("Ha habido algun fallo durante la operacion de actualizacion");
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }
    }

}
