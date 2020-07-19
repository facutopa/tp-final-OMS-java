# Trabajo Final OMS - Java - Programación 4

## Contenido
1. [Enunciado del TP](#enunciado-del-tp)
2. [Listado de Casos de Uso](#listado-de-casos-de-uso)
3. [Modelo de Clases](#modelo-de-clases)
 
### Enunciado del TP

**PARADIGMA DE ORIENTACIÓN  A OBJETOS -  TEMA DE FINAL.**

En la fecha de final Ud. deberá presentar una carpeta conteniendo el enunciado del tema asignado, el listado de todos los casos de uso que contemplará en la especificación del mismo,  la definición de las clases que utilizará con el árbol de jerarquía correspondiente y un CD con el ENUNCIADO del tema y el programa completo corriendo en Java.

**ORGANIZACIÓN MUNDIAL DE LA SALUD**

La Organización Mundial de La Salud maneja medicamentos que recibe como donación de laboratorios a fin de cubrir las necesidades de países que deben enfrentar una epidemia. Tiene para ello almacenada la información del stock de cada remedio que posee, de los países a los que normalmente abastece y de las “cajas tipo” que debe preparar para hacer frente a cada enfermedad, por persona, (por ej: malaria necesita antibiótico XXX, tantas unidades; antifebril WWW, tantas unidades y antinflamatorio ZZZ, tantas unidades), si para la enfermedad existe vacuna, la caja también contiene una dosis. Los remedios son gratuitos pues han sido donados y solamente tienen costo las cajas con vacunas, valor diferente para cada una de ellas. Ante el pedido de un país, la OMS prepara un envío con la cantidad de cajas solicitada, si es que posee todos los remedios necesarios para hacer frente a esa enfermedad. El envío puede mandarse completo o con la cantidad máxima de cajas completas que puedan prepararse de acuerdo al stock de los remedios necesarios y existentes ( las cajas no están armadas previamente, pues los diferentes remedios podrían usarse para armar distintos tipos de caja de acuerdo a los pedidos).
Todos los pedidos tienen además un costo fijo igual para todos ellos por el transporte, independiente de la cantidad de cajas. 

### Listado de Casos de Uso

1.	Registrar una donación de un determinado remedio.
2.	Registrar nueva Enfermedad y Caja-Tipo.
3.	Registrar nuevo Pedido de País.
4.	Registrar envió ante pedido pendiente.
5.	Modificar Caja-Tipo.
6.	Modificar pedido de País.
7.	Modificar costo de Envíos.
8.	Informar cual seria el costo total de un envío ya armado dado su código.
9.	Informar cuantos envíos se le han hecho en los últimos 3 años, dado el nombre de un país.
10.	Informar Enfermedades con vacuna.
11.	Informar el Stock existente de todos remedios.
12.	Informar los código de las caja-tipo que no pueden armarse por falta de stock.
13.	Listar enfermedades y sus caja tipo.
14.	Listar Pedidos.
15.	Listar Envíos.
98. Registrar nuevo empleado.
99. Precargar datos test (Países, Enfermedades, Remedios y Cajas-tipo).


*Aclaraciones:*
-	Todos los valores monetarios serán expresados en la moneda Dólar (USD).
- No se administraran los pagos de los Paises intervinientes.


### Modelo de Clases

![Imgur](https://i.imgur.com/1Z3cdMS.png)




