# 🔧 Solución de Problemas - Tech-Park UQ

## ✅ Cambios Realizados para Corregir Errores de Compilación

### 1. **pom.xml - Clase Principal Incorrecta**
**Problema:** El pom.xml apuntaba a `HelloApplication` que no existe.

**Solución:** Actualizado a:
```xml
<mainClass>
    co.edu.uniquindio.poo.techparkuq/co.edu.uniquindio.poo.techparkuq.view.MainApp
</mainClass>
```

---

### 2. **module-info.java - Falta de Exports**
**Problema:** JavaFX no podía acceder a las entidades del modelo para las TableView.

**Solución:** Agregado:
```java
exports co.edu.uniquindio.poo.techparkuq.model.entities;
opens co.edu.uniquindio.poo.techparkuq.model.entities to javafx.base;
opens co.edu.uniquindio.poo.techparkuq.model.abstracts to javafx.base;
```

---

### 3. **Visitante.java - Falta Setter para Saldo**
**Problema:** No se podía recargar el saldo del visitante.

**Solución:** Agregado método:
```java
public void setSaldoVirtual(float saldoVirtual) {
    this.saldoVirtual = saldoVirtual;
}
```

---

### 4. **Operador.java - Falta Getter para Zona**
**Problema:** No se podía acceder a la zona asignada del operador.

**Solución:** Agregado método:
```java
public Zona getZonaAsignada() {
    return zonaAsignada;
}
```

---

### 5. **Administrador.java - Falta Getters**
**Problema:** No se podían obtener las listas de empleados y atracciones.

**Solución:** Agregados métodos:
```java
public List<Empleado> getEmpleados() {
    return empleados;
}

public List<Atraccion> getAtracciones() {
    return atracciones;
}
```

---

### 6. **Atraccion.java - Falta Getters y toString**
**Problema:** No se podían mostrar las atracciones en ComboBox y TableView.

**Solución:** Agregados métodos:
```java
public String getNombre() {
    return nombre;
}

public int getTiempoEspera() {
    return tiempoEspera;
}

@Override
public String toString() {
    return nombre;
}
```

---

### 7. **VisitanteController.java - Recarga de Saldo**
**Problema:** La recarga de saldo no actualizaba el modelo.

**Solución:** Actualizado método:
```java
public void recargarSaldo(float monto) {
    float nuevoSaldo = visitante.getSaldoVirtual() + monto;
    visitante.setSaldoVirtual(nuevoSaldo);
    // ... mostrar alerta con nuevo saldo
}
```

---

### 8. **VisitanteView.java - Actualización de Label**
**Problema:** El label del saldo no se actualizaba después de recargar.

**Solución:** Actualizado para usar el valor real del modelo:
```java
lblSaldo.setText("Saldo Actual: $" + String.format("%.0f", visitante.getSaldoVirtual()));
```

---

## 🚀 Cómo Ejecutar el Proyecto

### Opción 1: Usando el Script (Recomendado)
```bash
ejecutar.bat
```

### Opción 2: Usando Maven Wrapper
```bash
# Compilar
mvnw.cmd clean compile

# Ejecutar
mvnw.cmd javafx:run
```

### Opción 3: Desde el IDE
1. Abrir el proyecto en IntelliJ IDEA o Eclipse
2. Ejecutar la clase `MainApp.java`
3. Asegurarse de que el IDE tenga configurado JavaFX

---

## ❌ Errores Comunes y Soluciones

### Error: "module not found: javafx.controls"
**Causa:** JavaFX no está instalado o configurado.

**Solución:**
1. Verificar que el pom.xml tenga las dependencias de JavaFX
2. Ejecutar: `mvnw.cmd clean install`
3. Usar el plugin de Maven: `mvnw.cmd javafx:run`

---

### Error: "Cannot access class X"
**Causa:** Falta export/open en module-info.java

**Solución:**
Verificar que module-info.java tenga:
```java
exports co.edu.uniquindio.poo.techparkuq.model.entities;
opens co.edu.uniquindio.poo.techparkuq.model.entities to javafx.base;
```

---

### Error: "PropertyValueFactory not working"
**Causa:** Las clases del modelo no tienen getters públicos.

**Solución:**
Asegurarse de que todas las propiedades usadas en TableColumn tengan getters:
```java
// Para TableColumn con cellValueFactory("nombre")
public String getNombre() {
    return nombre;
}
```

---

### Error: "NullPointerException en TableView"
**Causa:** ObservableList no inicializada o datos nulos.

**Solución:**
```java
ObservableList<Atraccion> lista = FXCollections.observableArrayList();
tabla.setItems(lista);
```

---

### Error: "ComboBox muestra direcciones de memoria"
**Causa:** Falta método toString() en la clase.

**Solución:**
```java
@Override
public String toString() {
    return nombre; // o cualquier representación legible
}
```

---

## 🔍 Verificación de Compilación

### Verificar que todo compile correctamente:
```bash
mvnw.cmd clean compile
```

### Salida esperada:
```
[INFO] BUILD SUCCESS
[INFO] Total time: XX s
```

---

## 📋 Checklist de Verificación

Antes de ejecutar, verificar:

- [ ] Java 17 o superior instalado
- [ ] Maven configurado (usar mvnw.cmd incluido)
- [ ] Todas las clases del modelo tienen getters necesarios
- [ ] module-info.java tiene todos los exports/opens
- [ ] pom.xml apunta a MainApp como clase principal
- [ ] No hay errores de compilación

---

## 🆘 Si Aún Hay Errores

### 1. Limpiar el proyecto completamente:
```bash
mvnw.cmd clean
rmdir /s /q target
mvnw.cmd compile
```

### 2. Verificar versión de Java:
```bash
java -version
```
Debe ser Java 17 o superior.

### 3. Verificar estructura de carpetas:
```
src/
├── main/
│   ├── java/
│   │   ├── co/edu/uniquindio/poo/techparkuq/
│   │   │   ├── controller/
│   │   │   ├── model/
│   │   │   └── view/
│   │   └── module-info.java
│   └── resources/
```

### 4. Revisar logs de error:
Los errores específicos aparecerán en la consola. Buscar:
- `cannot find symbol` → Falta import o getter
- `module not found` → Problema con module-info.java
- `class not found` → Problema con pom.xml

---

## 📞 Información de Depuración

Si necesita ayuda adicional, proporcione:
1. Mensaje de error completo
2. Versión de Java (`java -version`)
3. Sistema operativo
4. Salida de `mvnw.cmd clean compile`

---

## ✅ Estado Actual del Proyecto

Todos los errores conocidos han sido corregidos:
- ✅ Getters agregados en todas las entidades
- ✅ Setters necesarios implementados
- ✅ module-info.java configurado correctamente
- ✅ pom.xml apunta a la clase principal correcta
- ✅ ObservableList inicializadas correctamente
- ✅ toString() implementado donde es necesario

El proyecto debería compilar y ejecutarse sin errores.
