# 🎢 Tech-Park UQ - Guía Rápida de Usuario

## 🚀 Inicio de la Aplicación

### Ejecutar el Sistema
```bash
mvn clean javafx:run
```

---

## 🔐 Pantalla de Login

### Para Visitantes (Usuarios Existentes)
1. Ingrese su **cédula** en el campo de texto
2. Seleccione **"Visitante"** en el ComboBox de roles
3. Haga clic en **[Ingresar]**

### Para Nuevos Visitantes
1. Haga clic en **[Registrarse como Visitante]**
2. Complete el formulario:
   - Nombre completo
   - Cédula
   - Edad
   - Estatura (en metros, ej: 1.75)
3. Haga clic en **[OK]**
4. Inicie sesión con su cédula

### Usuarios de Prueba
- **Cédula: 1001** - Juan Pérez (Saldo: $100,000)
- **Cédula: 1002** - María García (Saldo: $50,000)
- **Cédula: 1003** - Pedro López (Saldo: $75,000)

---

## 👔 Modo Administrador

### 1️⃣ Gestión de Personal

#### Contratar un Operador
1. Complete el formulario:
   - Nombre del empleado
   - Cédula
   - Edad
   - ID de Empleado (único)
   - Zona asignada (seleccione del ComboBox)
2. Haga clic en **[Contratar Operador]**
3. El empleado aparecerá en la tabla

#### Desvincular un Empleado
1. Seleccione el empleado en la tabla
2. Haga clic en **[Desvincular Empleado]**
3. Confirme la acción

---

### 2️⃣ Gestión de Atracciones

#### Crear una Nueva Atracción
1. Complete todos los campos:
   - **ID**: Identificador único (ej: ATR006)
   - **Nombre**: Nombre de la atracción
   - **Capacidad**: Personas por ciclo
   - **Altura Mínima**: En metros (ej: 1.20)
   - **Edad Mínima**: En años
   - **Costo Adicional**: Precio extra ($)
   - **Tipo**: Seleccione del ComboBox
     - ACUATICA
     - MECANICA_ALTURA
     - INFANTIL
     - OTRO
2. Haga clic en **[Crear Atracción]**

#### Eliminar una Atracción
1. Seleccione la atracción en la tabla
2. Haga clic en **[Eliminar Atracción]**
3. La atracción se marcará como CERRADA (eliminación lógica)

---

### 3️⃣ Control Climático

#### Activar Alerta de Tormenta
1. Haga clic en **[ACTIVAR ALERTA: Tormenta/Lluvia Fuerte]**
2. El sistema automáticamente:
   - Cierra todas las atracciones ACUATICAS
   - Cierra todas las atracciones MECANICA_ALTURA
   - Notifica a los visitantes afectados

#### Desactivar Alerta
1. Haga clic en **[DESACTIVAR ALERTA]**
2. Las atracciones cerradas por clima se reactivarán

---

### 4️⃣ Reportes

#### Generar Reporte Diario
1. Haga clic en **[Generar Reporte Fin de Jornada]**
2. Revise la información:
   - Ingreso total del día
   - Atracción más visitada
   - Tiempo promedio de espera
   - Cierres por clima

---

## 🔧 Modo Operador

### 1️⃣ Control de Acceso

#### Validar Ingreso de un Visitante
1. Seleccione la **atracción** del ComboBox
2. Ingrese la **cédula del visitante**
3. Haga clic en **[Validar Ingreso]**

#### Posibles Resultados

✅ **Acceso Permitido**
- El visitante cumple todos los requisitos
- Se registra el ingreso
- El contador de visitas aumenta

❌ **Acceso Denegado - Atracción Cerrada**
- La atracción está en estado CERRADO
- No se permite el ingreso

❌ **Acceso Denegado - En Mantenimiento**
- La atracción alcanzó 500 visitas
- Requiere revisión técnica

❌ **Acceso Denegado - Requisitos**
- El visitante no cumple:
  - Edad mínima requerida
  - Altura mínima requerida

⚠️ **Límite de Mantenimiento Alcanzado**
- La atracción llegó a 500 visitas
- Estado cambia automáticamente a EN_MANTENIMIENTO
- Se debe realizar revisión técnica

---

### 2️⃣ Mantenimiento

#### Registrar Revisión Técnica
1. Vaya a la pestaña **"Mantenimiento"**
2. Revise la tabla de atracciones en mantenimiento
3. Seleccione la atracción revisada
4. Haga clic en **[Registrar Revisión Técnica]**
5. La atracción vuelve a estado ACTIVA
6. El contador de visitas se reinicia

---

## 🎢 Modo Visitante

### 1️⃣ Mi Perfil y Billetera

#### Ver Información Personal
- Nombre, cédula, edad y estatura se muestran automáticamente

#### Recargar Saldo
1. Haga clic en **[Recargar Saldo]**
2. Ingrese el monto a agregar
3. Haga clic en **[OK]**
4. El saldo se actualiza inmediatamente

---

### 2️⃣ Tienda de Tickets

#### Comprar Ticket General ($50,000)
- Acceso a todas las atracciones
- Sin prioridad en filas
- Costos adicionales aplican

#### Comprar Ticket Familiar ($150,000)
- Hasta 4 personas
- Descuento del 25%
- Acceso completo al parque

#### Comprar Fast-Pass ($80,000)
- Prioridad en todas las filas
- Acceso rápido
- Válido por 1 día

**Proceso de Compra:**
1. Haga clic en **[Comprar]** del ticket deseado
2. El sistema valida:
   - ✅ Saldo suficiente
   - ✅ Aforo disponible
3. Si todo está correcto, se confirma la compra

**Errores Comunes:**
- ❌ **Saldo Insuficiente**: Recargue su billetera
- ❌ **Aforo Máximo Alcanzado**: El parque está lleno

---

### 3️⃣ Mapa y Atracciones

#### Ver Atracciones Disponibles
- La tabla muestra todas las atracciones en tiempo real
- Columnas:
  - **Nombre**: Nombre de la atracción
  - **Tipo**: ACUATICA, MECANICA_ALTURA, INFANTIL, OTRO
  - **Estado**: ACTIVA, CERRADA, EN_MANTENIMIENTO
  - **Tiempo Espera**: Minutos estimados

#### Agregar a Favoritos
1. Localice la atracción en la tabla
2. Haga clic en **[⭐ Favorito]**
3. Recibirá notificaciones sobre esta atracción

#### Consultar Mapa
1. Haga clic en **[Ver Mapa Completo]**
2. Se muestra información general del parque

---

### 4️⃣ Centro de Notificaciones

#### Tipos de Notificaciones

📢 **Shows y Eventos**
- Horarios de espectáculos
- Eventos especiales

⛈️ **Alertas Climáticas**
- Cierres por tormenta
- Reaperturas después de clima

🔧 **Mantenimiento**
- Atracciones favoritas en mantenimiento
- Reaperturas después de revisión

---

## ⚠️ Mensajes de Error Comunes

### "Usuario no encontrado"
- Verifique que la cédula sea correcta
- Si es nuevo, regístrese primero

### "Saldo Insuficiente"
- Recargue su billetera virtual
- Verifique el costo del ticket

### "Aforo Máximo Alcanzado"
- El parque o zona está llena
- Intente más tarde

### "Atracción CERRADA"
- Puede estar cerrada por clima
- Puede estar en mantenimiento
- Consulte con el personal

### "No cumple requisitos"
- Verifique edad mínima
- Verifique altura mínima
- Consulte restricciones de la atracción

---

## 💡 Consejos y Trucos

### Para Visitantes
1. **Recargue saldo antes de llegar**: Evite filas en taquilla
2. **Revise el estado de atracciones**: Planifique su visita
3. **Agregue favoritos**: Reciba notificaciones importantes
4. **Compre Fast-Pass**: Ahorre tiempo en filas largas

### Para Operadores
1. **Revise la tabla regularmente**: Identifique atracciones cerca del límite
2. **Valide cuidadosamente**: La seguridad es primero
3. **Registre mantenimientos rápido**: Minimice tiempo de inactividad

### Para Administradores
1. **Monitoree el clima**: Active alertas preventivamente
2. **Revise reportes diarios**: Identifique tendencias
3. **Gestione personal eficientemente**: Asigne zonas estratégicamente

---

## 🆘 Soporte

Si encuentra problemas:
1. Verifique que todos los campos estén completos
2. Revise los mensajes de error
3. Consulte esta guía
4. Contacte al administrador del sistema

---

## 📱 Atajos de Teclado

- **Tab**: Navegar entre campos
- **Enter**: Confirmar en diálogos
- **Esc**: Cancelar diálogos

---

## ✅ Checklist de Inicio

### Primera Vez como Visitante
- [ ] Registrarse en el sistema
- [ ] Recargar saldo inicial
- [ ] Explorar atracciones disponibles
- [ ] Comprar ticket de entrada
- [ ] Agregar atracciones favoritas

### Primera Vez como Operador
- [ ] Verificar zona asignada
- [ ] Revisar atracciones de la zona
- [ ] Familiarizarse con el proceso de validación
- [ ] Revisar atracciones en mantenimiento

### Primera Vez como Administrador
- [ ] Revisar personal actual
- [ ] Verificar estado de atracciones
- [ ] Configurar alertas climáticas
- [ ] Generar reporte inicial

---

¡Disfrute de Tech-Park UQ! 🎉
