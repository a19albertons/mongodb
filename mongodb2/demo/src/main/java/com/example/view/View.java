package com.example.view;

import java.util.Arrays;
import java.util.Scanner;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.example.controller.ControladorGeneral;
import com.mongodb.client.model.Filters;

/**
 * Vista de la aplicación
 */
public class View {
    private ControladorGeneral controladorGeneral;

    /**
     * constructor de la vista
     * 
     * @param controladorGeneral controlador general de la aplicación
     */
    public View(ControladorGeneral controladorGeneral) {
        this.controladorGeneral = controladorGeneral;
    }

    /**
     * constructor de la vista
     */
    public void inicializar() {
        System.out.println("Vista inicializada");

        try (Scanner sc = new Scanner(System.in)) {
            // Añadir empleados

            // controladorGeneral.getEmpleadoController().crearEmpleado(1, "Juan", 10, 1000,
            // "10/10/1999", null, 0);
            // controladorGeneral.getEmpleadoController().crearEmpleado(2, "Alicia", 10,
            // 1400, "07/08/2000", "Profesora",
            // 0);
            // controladorGeneral.getEmpleadoController().crearEmpleado(3, "María Jesús",
            // 20, 1500, "05/01/2005",
            // "Analista", 100);
            // controladorGeneral.getEmpleadoController().crearEmpleado(4, "Alberto", 20,
            // 1100, "15/11/2001", null, 0);
            // controladorGeneral.getEmpleadoController().crearEmpleado(5, "Fernando", 30,
            // 1400, "20/11/1999", "Analista",
            // 200);

            // Consultas 1
            Bson filtro1 = Filters.eq("dep", 10);
            String salida = controladorGeneral.getEmpleadoController().filtrarEmpleados(filtro1);
            System.out.println(salida);

            // Consulta 2
            Bson filtro2 = Filters.or(Filters.eq("dep", 10), Filters.eq("dep", 20));
            String salida2 = controladorGeneral.getEmpleadoController().filtrarEmpleados(filtro2);
            System.out.println(salida2);

            // Consulta 3
            Bson filtro3 = Filters.and(Filters.gt("salario", 1300), Filters.eq("oficio", "Profesora"));
            String salida3 = controladorGeneral.getEmpleadoController().filtrarEmpleados(filtro3);
            System.out.println(salida3);

            // Actualización 4
            Bson filtro4 = Filters.eq("oficio", "Analista");
            Bson actualizacion4 = new Document("$inc", new Document("salario", 100));
            controladorGeneral.getEmpleadoController().actualizarEmpleados(filtro4, actualizacion4);

            // Actualizacion 5
            // Parte A mayores de 20 en comision
            Bson filtro5A = Filters.gt("comision", 20);
            Bson actualizacionA = new Document("$inc", new Document("comision", -20));
            controladorGeneral.getEmpleadoController().actualizarEmpleados(filtro5A, actualizacionA);

            // Parte B menores o iguales de 20 en comision
            Bson filtro5B = Filters.lte("comision", 20);
            Bson actualizacionB = new Document("$set", new Document("comision", 0));
            controladorGeneral.getEmpleadoController().actualizarEmpleados(filtro5B, actualizacionB);

            // Consulta 6
            Bson filtro6 = new Document("$group", new Document()
                    .append("_id", null) // null = promedio global
                    .append("promedioSalario", new Document("$avg", "$salario")));
            String salida6 = controladorGeneral.getEmpleadoController().filtrarEmpleadosAvanzados(filtro6);
            System.out.println(salida6);

            // Consulta 7 Visualiza por departamento el numero de empleados, salario medio y
            // el maximo salario
            Bson filtro7 = new Document("$group", new Document()
                    .append("_id", "$dep") // agrupar por departamento
                    .append("numEmpleados", new Document("$sum", 1))
                    .append("salarioMedio", new Document("$avg", "$salario"))
                    .append("salarioMaximo", new Document("$max", "$salario")));
            String salida7 = controladorGeneral.getEmpleadoController().filtrarEmpleadosAvanzados(filtro7);
            System.out.println(salida7);

            // List<Bson> pipeline = List.of(aggregate.group("$dep",
            // Accumulators.sum("numEmpleados", 1),
            // Accumulators.avg("SalarioMedio", "$salario"),
            // Accumulators.max("salarioMaximo", "$salario")),
            // Aggregates.sort(Sorts.ascenging("dep")))

            // Consulta 8 Visualiza solo el nombre del empleado con el mayor salario
            // Ordena por salario descendiente, solo muestre el nombre y limite a 1
            // resultado
            Bson ordenar8 = new Document("$sort", new Document("salario", -1));
            Bson devolver8 = new Document("$project", new Document("_id", 0).append("nombre", 1));
            Bson limite8 = new Document("$limit", 1);
            String salida8 = controladorGeneral.getEmpleadoController()
                    .filtrarEmpleadosAvanzados(Arrays.asList(ordenar8, devolver8, limite8));
            System.out.println(salida8);

        } catch (Exception e) {
            System.out.println("Fallo en la vista no esperado");
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }
    }

}
