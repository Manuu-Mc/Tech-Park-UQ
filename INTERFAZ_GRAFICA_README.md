# Tech-Park UQ - Interfaz Gráfica JavaFX

## 📋 Descripción General

Sistema de gestión completo para el parque de diversiones "Tech-Park UQ" con interfaz gráfica JavaFX implementando el patrón MVC (Model-View-Controller).

## 🏗️ Arquitectura del Sistema

### Estructura de Paquetes

```
co.edu.uniquindio.poo.techparkuq/
├── controller/
│   ├── ParqueController.java       # Controlador principal del parque
│   ├── LoginController.java        # Gestión de autenticación
│   ├── AdminController.java        # Lógica del administrador
│   ├── OperadorController.java     # Lógica del operador
│   └── VisitanteController.java    # Lógica del visitante
├── view/
│   ├── MainApp.java                # Aplicación principal
│   ├── LoginView.java              # Pantalla de inicio de sesión
│   ├── AdminView.java              # Dashboard del administrador
│   ├── OperadorView.java           # Dashboard del operador
│   └── VisitanteView.java          # Dashboard del visitante
└── model/
    ├── entities/                   # Entidades del dominio
    ├── abstracts/                  # Clases abstractas
    ├── enums/                      # Enumeraciones
    ├── interfaces/                 # Interfaces
    └── records/                    # Records de datos
```

## 🚀 Inicio Rápido

### Ejecutar la Aplicación

```bash
mvn clean javafx:run
```

### Datos de Prueba Precargados

**Visitantes:**
- Cédula: `1001` - Juan Pérez (Saldo: $100,000)
- Cédula: `1002` - María García (Saldo: $50,000)
- Cédula: `1003` - Pedro López (Saldo: $75,000)

**Atracciones:**
- Montaña Rusa Extrema (MECANICA_ALTURA)
- Tobogán Acuático (ACUATICA)
- Carrusel Mágico (INFANTIL)
- Rueda de la Fortuna (MECANICA_ALTURA)
- Piscina de Olas (ACUATICA)

## 👥 Roles y Funcionalidades

### 1. 🔐 Pantalla de Login

**Componentes:**
- Campo de texto: Cédula/ID
- ComboBox: Selector de rol (Visitante, Operador, Administrador)
- Botón [Ingresar]: Autentica y redirige al dashboard correspondiente
- Botón [Registrarse como Visitante]: Abre formulario de registro

**Funcionalidad:**
- Valida la existencia del usuario en el sistema
- Redirige según el tipo de usuario (instanceof)
- Permite registro rápido de nuevos visitantes

---

### 2. 👔 Dashboard del Administrador

#### Pestaña 1: Gestión de Personal

**Formulario de Contratación:**
- Nombre, Cédula, Edad, ID Empleado
- ComboBox: Zona asignada (para Operadores)

**Botones:**
- `[Contratar Operador]`: Crea un nuevo operador y lo asigna a una zona
- `[Desvincular Empleado]`: Elimina empleado seleccionado de la tabla
- `[Actualizar Datos]`: Modifica información del empleado

**Tabla de Empleados:**
- Columnas: Nombre, Cédula, ID Empleado
- Selección para desvincular

#### Pestaña 2: Gestión de Atracciones

**Formulario de Creación:**
- ID, Nombre, Capacidad
- Altura Mínima, Edad Mínima
- Costo Adicional
- ComboBox: Tipo (ACUATICA, MECANICA_ALTURA, INFANTIL, OTRO)

**Botones:**
- `[Crear Atracción]`: Registra nueva atracción en el sistema
- `[Eliminar Atracción]`: Cierre lógico (estado = CERRADO)

**Tabla de Atracciones:**
- Columnas: Nombre, Tipo, Estado
- Actualización automática con ObservableList

#### Pestaña 3: Control Climático

**Panel de Alertas:**
- `[ACTIVAR ALERTA: Tormenta/Lluvia Fuerte]`
  - Cierra automáticamente todas las atracciones ACUATICA y MECANICA_ALTURA
  - Cambia estado a CERRADO
  - Genera notificaciones a visitantes
  
- `[DESACTIVAR ALERTA]`
  - Reactiva atracciones cerradas por clima
  - Cambia estado a ACTIVA

**Lógica Implementada:**
```java
administrador.activarAlertaClimatica();
// Itera sobre todas las atracciones
// Si tipo == ACUATICA || MECANICA_ALTURA
// -> setEstadoActual(CERRADO)
```

#### Pestaña 4: Reportes

**Botón:**
- `[Generar Reporte Fin de Jornada]`

**Información Mostrada:**
- Ingreso total del día
- Atracción más visitada
- Tiempo promedio de espera
- Cantidad de cierres por clima

---

### 3. 🔧 Dashboard del Operador

#### Panel Superior
- Muestra la zona asignada
- Capacidad máxima vs aforo actual

#### Pestaña 1: Control de Acceso

**Formulario de Validación:**
- ComboBox: Seleccionar atracción (filtrada por zona)
- TextField: Cédula del visitante o ID del ticket

**Botón:**
- `[Validar Ingreso]`

**Validaciones Automáticas:**
1. ✅ Verifica que la atracción esté ACTIVA
2. ✅ Valida edad mínima del visitante
3. ✅ Valida estatura mínima del visitante
4. ✅ Verifica saldo para costos adicionales
5. ✅ Registra el ingreso (contador++)
6. ⚠️ Si contador == 500 → Estado = EN_MANTENIMIENTO

**Alertas:**
- `ERROR`: Atracción CERRADA o EN_MANTENIMIENTO
- `ERROR`: Visitante no cumple requisitos
- `WARNING`: Límite de 500 visitas alcanzado
- `INFORMATION`: Acceso permitido

**Código de Validación:**
```java
boolean accesoValido = operador.validarAcceso(visitante, atraccion);
if (!accesoValido) {
    // Mostrar alerta de error
}
atraccion.registrarIngreso();
if (atraccion.getEstadoActual() == EN_MANTENIMIENTO) {
    // Mostrar alerta de mantenimiento
}
```

#### Pestaña 2: Mantenimiento

**Tabla:**
- Lista de atracciones en estado EN_MANTENIMIENTO
- Filtradas por zona del operador

**Botón:**
- `[Registrar Revisión Técnica]`
  - Cambia estado a ACTIVA
  - Reinicia contador de visitas
  - Reactiva la atracción

---

### 4. 🎢 Dashboard del Visitante

#### Pestaña 1: Mi Perfil y Billetera

**Información Personal:**
- Nombre, Cédula, Edad, Estatura
- ImageView para foto (opcional)

**Billetera Virtual:**
- Label: Saldo actual
- Botón `[Recargar Saldo]`
  - Abre TextInputDialog
  - Valida monto > 0
  - Actualiza saldo

#### Pestaña 2: Tienda de Tickets

**Cards de Tickets:**

1. **Ticket General - $50,000**
   - Acceso a todas las atracciones
   - Sin prioridad en filas
   - Costos adicionales aplican

2. **Ticket Familiar - $150,000**
   - Hasta 4 personas
   - Descuento del 25%
   - Acceso completo

3. **Fast-Pass - $80,000**
   - Prioridad en todas las filas
   - Acceso rápido
   - Válido por 1 día

**Validaciones:**
- Verifica saldo suficiente
- Valida aforo del parque
- Muestra error si zona está llena

**Código de Compra:**
```java
if (visitante.getSaldoVirtual() < costoTicket) {
    mostrarAlerta("Saldo Insuficiente", ...);
    return;
}
visitante.comprarTicketVirtual();
```

#### Pestaña 3: Mapa y Atracciones

**Tabla de Atracciones:**
- Columnas: Nombre, Tipo, Estado, Tiempo de Espera
- Botón por fila: `[⭐ Favorito]`

**Funcionalidades:**
- Ver todas las atracciones en tiempo real
- Agregar a favoritos
- Consultar tiempo de espera
- Indicador de Fast-Pass activo

#### Pestaña 4: Centro de Notificaciones

**ListView de Notificaciones:**
- Muestra mensajes de:
  - Shows y eventos especiales
  - Alertas climáticas
  - Mantenimiento de atracciones favoritas

**Actualización Automática:**
- Se actualiza cuando el administrador activa alertas
- Se actualiza cuando operador cierra atracción favorita

---

## 🎨 Características de UI/UX

### Manejo de Alertas
Todas las operaciones críticas muestran alertas JavaFX:

```java
Alert alert = new Alert(Alert.AlertType.INFORMATION);
alert.setTitle("Título");
alert.setHeaderText(null);
alert.setContentText("Mensaje");
alert.showAndWait();
```

**Tipos de Alertas:**
- `INFORMATION`: Operaciones exitosas
- `WARNING`: Advertencias (límite de mantenimiento)
- `ERROR`: Errores de validación
- `CONFIRMATION`: Confirmaciones de acciones

### Sincronización de Datos

**ObservableList:**
```java
ObservableList<Atraccion> atraccionesObservable = 
    FXCollections.observableArrayList(parqueController.getAtracciones());
```

- Actualización automática de tablas
- Sincronización entre vistas
- Refresco en tiempo real

### Estilos CSS Inline

```java
button.setStyle("-fx-background-color: #4CAF50; " +
                "-fx-text-fill: white; " +
                "-fx-font-size: 14px;");
```

---

## 🔒 Encapsulamiento y Patrón MVC

### Separación de Responsabilidades

**Controladores (Controller):**
- NO contienen lógica de negocio directa
- Llaman a métodos del modelo
- Gestionan la comunicación entre Vista y Modelo

**Vistas (View):**
- Solo presentación y captura de eventos
- Delegan acciones a los controladores
- No acceden directamente al modelo

**Modelo (Model):**
- Contiene toda la lógica de negocio
- Reglas de validación
- Persistencia de datos

### Ejemplo de Flujo:

```
Usuario hace clic en [Validar Ingreso]
    ↓
OperadorView captura el evento
    ↓
Llama a operadorController.validarIngresoVisitante()
    ↓
Controller llama a operador.validarAcceso() (Modelo)
    ↓
Modelo ejecuta lógica de negocio
    ↓
Controller muestra resultado en Alert
    ↓
Vista se actualiza automáticamente (ObservableList)
```

---

## 📊 Reglas de Negocio Implementadas

### 1. Validación de Acceso a Atracciones
- ✅ Edad mínima requerida
- ✅ Altura mínima requerida
- ✅ Estado de la atracción (ACTIVA/CERRADA/MANTENIMIENTO)
- ✅ Saldo suficiente para costos adicionales

### 2. Mantenimiento Automático
- ✅ Contador de visitas por atracción
- ✅ Al llegar a 500 visitas → EN_MANTENIMIENTO
- ✅ Alerta automática al operador
- ✅ Bloqueo de nuevos ingresos

### 3. Alertas Climáticas
- ✅ Cierre masivo de atracciones específicas
- ✅ Notificación a visitantes afectados
- ✅ Reactivación controlada

### 4. Gestión de Tickets
- ✅ Validación de saldo
- ✅ Control de aforo
- ✅ Descuentos automáticos (Familiar)
- ✅ Prioridad en filas (Fast-Pass)

---

## 🛠️ Tecnologías Utilizadas

- **JavaFX 21**: Framework de interfaz gráfica
- **Java 17+**: Lenguaje de programación
- **Maven**: Gestión de dependencias
- **Patrón MVC**: Arquitectura de software

---

## 📝 Notas Importantes

1. **Datos de Prueba**: La aplicación carga automáticamente visitantes y atracciones de prueba al iniciar.

2. **Persistencia**: Actualmente los datos se mantienen en memoria. Para persistencia real, integrar con `PersistenciaUtil.java`.

3. **Extensibilidad**: El sistema está diseñado para agregar fácilmente:
   - Nuevos tipos de tickets
   - Nuevas validaciones
   - Reportes adicionales
   - Integración con bases de datos

4. **Seguridad**: En producción, implementar:
   - Autenticación real con contraseñas encriptadas
   - Roles y permisos más granulares
   - Logs de auditoría

---

## 🎯 Próximos Pasos

- [ ] Integrar persistencia con archivos/base de datos
- [ ] Implementar sistema de autenticación robusto
- [ ] Agregar gráficos y estadísticas visuales
- [ ] Implementar sistema de notificaciones push
- [ ] Crear módulo de reportes avanzados
- [ ] Agregar soporte multiidioma

---

## 👨‍💻 Desarrollo

**Patrón de Diseño**: MVC (Model-View-Controller)
**Principios SOLID**: Aplicados en toda la arquitectura
**Clean Code**: Código limpio y mantenible

---

## 📞 Soporte

Para dudas o problemas, revisar la documentación del código fuente. Cada clase está documentada con JavaDoc.
