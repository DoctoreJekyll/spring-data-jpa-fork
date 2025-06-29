Día 16. Recap de proyecto spring JPA desde el principio.
-
- Hemos instalado JPA Buddy, un helper para JPA.
- Creamos estructura básica de paquetes, entities, dto., services, repo controllers. Recordatorio crear las carpetas dentro de la
Carpeta de proyecto, donde está la clase main
- Desde el puto jpa buddy podemos generar entidades de forma automática, es god.
- Vimos la etiqueta para insertar finals que recuerde pero por convención es mejor no usar la etiqueta y hacerlo desde constructor
- Las reglas de negocio iran en nuestro service que accede al repo, eso ya se menciono creo
- Luego hemos estado haciendo paso a paso la construcción de un controlador, de hacer el getmapping tipico de listado de usuarios
y hemos hecho el html paso a paso con un th each y tal del html, yo lo he hecho con chati
- 1 horita con un error de chill(ha sido hora y media era culpa de Lombok, lo ha solucionado quitando lombok y añadiendo setters y getters manualmente)
- Al final han sido como 2 horas
- Igual más
- Creo que ya llevamos 3 he perdido la cuenta
- Le ha vuelto a dar error cuando creia que lo tenia solucionado, **golpe en la mesa**, *que coño pasa*
- Hemos utilizado el jpa buddy para generar todas las entidades pero requieren ciertas configuraciones, te las enseñare
- Despues hay que revisar porque crea entidades y valores de todo lo que cree necesario osea que alomejor mete basurilla que nunca vamos a usar
- Te ayuda facilitando la creacion de todas las entidades pero te quita cierto control porque no sabes que estás creando
- Hemos expuesto cada entidad y revisado las relaciones que el plugin ha generado, algo particular de esta tabla en conreto estas relaciones pueden ser distintas para cada tabla
- Hemos explicado el concepto de la etiqueta @Mappedby que era lo que usamos
- Los ultimos minutos de clase ha repasado el concepto de relaciones y porque a veces necesitamos relaciones manytoone y onetomany o onetoone, esto no me he podido enterar del todo bien
- Revisar codigo oficina unique.
- Repo de Carlos https://github.com/carlos2501/ejercicioClase-VII-spring-data-jpa



Día 17. Se ha puesto la skin veraniega, creo que está en el pisito de Malaga, ahora lleva polito azul descamisado.
-
- Vamos a repasar de primeras como hacer el html este que era generico, el "vistaLista".
- Cada vez que estamos teniendo entidades con un String como clave primaria, como el caso de las gamas o las oficinas estamos creandole nosotros mismos un ID con un Integer y su @Id y @GeneratedValue
- Para guardar imagenes, no guardamos dentro de la base, en la base guardamos una URL
- Tiene un perrochi porai
- Todos los @manytomani o onetomany, lo que haciamos que teniamos que convertir en listas tenemos que hacerlas de tipo "Set" y no de tipo List. Set es una colección igual que List pero por dentro Java a los Set le aplica una clave. Iniciamos estos Set con new LinkedHashSet<>(). Por ejemplo, Set<Gama> gamas = new LinkedHashSet<>()
- @JoinTable(name = "gama_productos"), el Jointable construye una tabla intermedia(name es el nombre de esta tabla intermedia) por dentro, se lo ponemos a los manytomany, para hacer esta tabla ficticia usa las PK de cada entidad
- Ha preguntado que donde estamos que no nos encuentra, que el micro leñe, el micro
- Ejemplo tabla intermedia Cursos/Alumnos ![img_1.png](img_1.png) Para poner ejemplo que si no necesitamos mas campos esto no necesitamos hacerlo en clases, lo que nos explicó el chati vaya, para tablas asi con definir lo de @manytomany es suficiente. 
- En caso de necesitar mas información que guardemos en nuestra tabla intermedia con campos que afecten a mi tabla alumnos y cursos si que tenemos que hacer ciertas definiciones
- ..........
- ..........
- ..........
- ..........
- Vamos a cambiar los nombres de las tablas porque no le gustan
- (Esto lo ha desechado le daba errores fjsd)Lo haremos duplicando la tabla jardineria para tampoco joder la de jardinieria principal. Hemos hecho un backup que es lo que hicimos con Jose Manuel
- Acaba de decir, "ole, no hay nada como acertar"
- Hemos renombrado los nombres de las tablas al plural porque le gusta mas asi y se supone que se debe hacer asi.
- Hemos hecho un ejemplo de lo dee Embeddable con una clase llamada ProductoGamaPK que seria el proceso a seguir si en la tabla intermedia tenemos mas campos que registrar y no queremos que se gestione solo.
- Con esto nos peleamos un poco ya cuando hicimos nosotros el ejemplo con el ejercicio de pedidos
- Aaron tiene calle
- *Que pasa si borras un producto o una gama que esten relacionadas entre si?* Si borras una gama que esta asociada a varios productos, dice que dependerá de la casuistica que tratamos, pero está mencionando algo llamado operaciones en "Cascada". Es como vale, si haces algo con el registro padre, que tenemos que hacer con los registros hijos.
- https://vladmihalcea.com/a-beginners-guide-to-jpa-and-hibernate-cascade-types/  Ha dejado este link como referencias
- ![img_2.png](img_2.png)
- Por ejemplo si la operacion es ALL, cualquier oiperacion que hagamos en la tabla A, borramos todos los registros en la tabla B, por tanto hay que tener mucho cuidado con este tipo de operaciones.
- Normalmente usamos MERGE(ACTUALIZAR) Y PERSIST. Con ALL y REMOVE hay que tener cuidado por eso porque pilla todo.
- Como usamos estas movidas de cascadas?
- @ManyToMany(mappedBy = "productos", cascade = {CascadeType.PERSIST, CascadeType.MERGE}). En las propias relaciones indicamos el tipo de cascada.
- Significa que las operaciones PERSIST (guardar) y MERGE (actualizar) hechas sobre la entidad que contiene esta colección (posiblemente Producto) también se aplicarán automáticamente a las entidades Gama relacionadas, siempre y cuando estas entidades Gama estén asociadas en la colección gamas
- También hay porai un chiquillo o una chiquilla que grita, te estaría haciendo mucha gracia con los cascos puestos eso
- No grita poco ni bajito
- Para el estado de pedido de la clase pedido hemos hecho una clase auxiliar llamada EstadoPedido para que los estados esten acotados a los que nosotros queramos, modelo de negocio
- Ahora vamos a revisar como cargar registros, el tema de fetch, fetchLazy, perezosa y eso
- Bueno ha dicho que le echemos un ojo nosotros de cuando usar un tipo u otro, ha dejado este enlace https://thorben-janssen.com/entity-mappings-introduction-jpa-fetchtypes/
- Hemos estado un rato con un ejemplo externo para repasar el tema de tablas intermedias y tablas muchos a muchos, un caso de un formulario de pedidos, que tenemos que relacion Pedido, Producto, Cliente, etc y sale tabla intermedia entre Pedido y Producto.
- Descanso AAAAAAAAAA
- Si lees esto te abrazo fuerte, cuidate mucho
- Siempre que usemos clases con keys compuestas, es decir estas clases que vienen de tablas intermedias donde hacemos lo del embed y todo eso tenemos que insertar el equal y hash que se hace con el alt+insert y pone equal y hash algo, he disociado un poco aqui perdon
- Nos ha pedido que hagamos nosotros los pagos, hacer nosotros es como cambiar ciertos nombres tiene bastantes lios con tema tablas, me tocara hacer un fork de su proyecto e ir revisando cada nombre para ir cambiando el nombre de las tablas y de las columnas
- Ha intentado compilar y le ha dado bastantes errores por varios lados por estar cambiando tantos nombres y me estoy liando un monton
- Una cosa que esta haciendo ahora, en el caso de oficina creo que ya te comente que metió el su propia ID desde codigo porque las oficinas tenian las ids estas suyas propias, pues al meter tu la id por codigo al parecer jpa inserta el campo id automaticamente peero tiene que quitar que el codigooficina que es el antiguo sea la pk
- Se le estan jodiendo bastantes cosas por querer cambiar tantos nombres ya que habia muchas cosas enlazadas por pks y fks y varias relaciones y tal tal
- Seguramente se enfadará en los próximos minutos
- Se ha enfadado
- Creo que va a desechar cosas
- "En aras de continuar con el ejemplo voy a quitar todo esto" 
- Le sigue fallando
- Se ha metido en el pgAdming y se ha puesto a hacer muchas consultas para actualizar un monton de datos
- Sigue en el pgAdmin haciendo muchos cambios es una cosa se ha vuelto loco


Día 18, hoy polito rojo de ferrari, totalmente desatado.
-
- Empezamos de nuevo a repasar el concepto de Factoria y las vistas genericas html
- Pinta a que tiene un perrochi chico, tipo caniche o yorsai, le pega
- Hemos ya generado el primer DTO para transportar solo los datos que queremos de la entidad Cliente
- En nuestro servicio hemos hecho un minimapper para recibir un cliente y devolver un DTO y poder usarlo, esto ha dicho que podemos hacerlo de muchas formas, sacar el mapper fuera o mapstruct tal tal
- Todo esto lo hacemos como hemos solido hacer porque modelo de negocio solo queremos que nuestra vista devuelva en este caso el nombre, codigo postal ciudad y un par de cosas mas
- Ahora hemos hecho, cosa de la factoria, otra clase para implementar el servicio en la factoria
- Hay una señora de fondo que habla en un idioma desconocido, creo que es catalán.
- O francés, o no se igual se lo está inventando es posible
- Son las 11 30 y hemos hecho recap de lo que hicimos con el otro proyecto, hacer las factorias, hacer de nuevo lo del map para poder tener las clases gnericas y poder tener htmls genericos para todas las entidades
- Nos ha mandado hacer digamos rellenar las factorias de distintas entidades en base a las 2 que hemos hecho en clase para poder ver por pantalla tablas de mas entidades, repetir el codigo de la factoria para interiorizar un poco
- Nos ha dado un script de sql con las tablas modificadas suyas de ayer, esta en su repo y yo tambien lo he guardado por si acaso
- El resumen de estas 4h han sido esa son justo las 13.00, hemos hecho de nuevo todo el proceso de factoría, html y controladores genericos como repaso y nos ha mandado a replicar durante un rato
- Ahora esta corrigiendo el y haciendolo
- Joder te echo bastante de menos, pienso un montón en tí, ojalá poder quitarte solo una porción del dolor que llevas.
- Ahora estamos editando el html de vistas, hemos puesto un boton que pulsaremos para abrir digamos las tablas de oficinas
- Es un poco juguetear con el html y los datos no estamos dando contenido nuevo como tal
- Quiere hacer un acordeon con cada fila de Oficinas, algo parecido a lo que hicimos nosotros con pedidos y productos pero con oficinas y empleados
- Por cierto al final el DTO que hemos hecho al principio de la clase no lo hemos utilizado, me acabo de dar cuenta
- Osea que el minimapper tampoco se usa
- Peleas con html front

Día 20, volvemos con el html, visualizar tablas dentro de tablas.
-
- Hoy estamos resolviendo de momento varios conceptos de html
- Como exponer listas, th if, th each, cosas que podemos ir haciendo en realidad con IAs ha sido al final el resumen de esto
- Vamos a ver distintos conceptos, ahora ha mencionado tema de patrones de diseño y nos ha recomendado esta pagina https://refactoring.guru/es/design-patterns
- Hemos pasado por encima sobre la importancia de tener o de saber patrones de diseño, da valor y ha recomendado buscar alguna lectura sobre el tema
- El tema de los html bajo resumen es lo que hemos hablado, realmente conociendo el backend y la parte de programación puedes pasarle tu codigo a la IA y te genera los html faciles.
- Ahora estamos generando un formulario para Oficinas, pasamos por el servicio y hacemos lo de findbyid para luego en el controlador buscar una oficina y pasarle los valores al formulario para editar
- Hemos visto que hace exactamente la etiqueta @ModelAttribute, es como que nos ahorra usar el Model porque con esa etiqueta ya el html directamente nos coge el campo
- Es decir, la variable que pasemos junto al ModelAttribute es como nuestra "patata" que luego vamos a pasarle al html/thymeleaf, tipo th:text patata.nombre y no hemos necesitado hacer el model.addAtribute(patata)
- Vale pues no, el ModelAttribute no reemplaza nada, solo nos sirve para devolver valores de vuelta, osea nos sirve por ejemplo en el metodo/accion del postmppaing, de vuelta siginifica que seria del html a nuestra base, para enseñar datos de nuestra base al html seria el Model
- Luego hemos estado un rato repitiendo la asignacion de endpoints para seguire generalizando desde htmls
- Ahora nos ha mandado un ejercicio, que debajo de los formularios de las oficinas salga una tabla con los empleados de esa oficina que vamos a actualizar
- 