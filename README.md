# Inmobiliaria_Zanche_Martin
App Inmobiliaria android java

APP Móvil:
La inmobiliaria dispone de una aplicación móvil para los propietarios, los que podrán
acceder previo registro.
Funcionalidad:
● Habilitar/Deshabilitar la disponibilidad de una propiedad.
● Recibir notificaciones de pagos de alquiler.
● Visualizar información personal del inquilino.
● Visualizar información de contratos.
● Editar su información personal.

Prototipos APP(Sugeridos) :
Mientras el usuario esté en la Activity de Login, si agita el teléfono hará una llamada a la
inmobiliaria.

-Fragment Inicio, mostrando ubicación de la Inmobiliaria.
-Fragment Perfil: Este fragment muestra toda la información del
Propietario logueado. Al hacer clic en el Botón "Editar" podrá
modificar cualquiera de sus datos, menos el código o id del
Propietario. Este botón cuando está en modo "edición" cambiará a
guardar para que cuando el usuario haga clic en el mismo pueda
almacenar sus datos.
-Fragment Inmuebles: Muestra una lista con los datos más
relevantes de las propiedades del usuario logueado.
Cuando tocamos sobre uno de estos ítems, navegamos a un
fragment donde se visualizará el detalle del inmueble
seleccionado.
-Fragment Inquilinos: Este fragment, mostrará una lista de los
inmuebles actualmente alquilados del propietario que inició
sesión. Al hacer clic en uno de los items, mostrará información del
inquilino del mismo.
-Fragment Contratos: Al igual que el fragment anterior, muestra
una lista de los inmuebles actualmente alquilados (o sea que
tienen un contrato) y al hacer clic en uno de los ítems, mostrará
detalle del contrato
-Fragment Logout: En este fragment aparece un diálogo en
donde preguntará al usuario si confirma la acción de cerrar sesión.
