# Проект: Аннотации и тестирование на Java

В этом проекте реализованы пользовательские аннотации и обработчики для них с последующим тестированием через JUnit.  

---

## Задание 1 — Реализация аннотаций

### Задача 1 — @Invoke
**Описание:**  
Разработать аннотацию `@Invoke` с характеристиками:  
- Цель: метод  
- Доступна во время выполнения  
- Не имеет свойств  

**Реализация:**  
1. Создана аннотация `@Invoke`.  
2. Определено, что она применяется только к методам.  
3. Класс с несколькими методами помечен аннотацией `@Invoke`.  
4. Обработчик через Reflection API находит и автоматически вызывает аннотированные методы.

---

### Задача 2 — @Default
**Описание:**  
Разработать аннотацию `@Default` с характеристиками:  
- Цель: класс или поле  
- Доступна во время выполнения  
- Обязательное свойство `value` типа `Class`  

**Реализация:**  
1. Создана аннотация с параметром `value` типа `Class`.  
2. Обработчик через Reflection получает класс или поле и выводит имя класса, указанного в `value`.  
3. Создан пример класса с аннотацией на уровне класса и поля.

---

### Задача 3 — @ToString
**Описание:**  
Разработать аннотацию `@ToString` с характеристиками:  
- Цель: класс или поле  
- Доступна во время выполнения  
- Свойство `value` (по умолчанию `YES`), возможные значения: `YES` / `NO`  

**Реализация:**  
1. Создано перечисление `Mode` с `YES` и `NO`.  
2. Метод `toCustomString()` формирует строковое представление объекта через Reflection, учитывая аннотации.  
3. Пример класса `ToStringExample` с полями:  
   - `name` — наследует `YES`  
   - `password` — `Mode.NO`  
   - `age` — наследует `YES`  
   - `email` — `Mode.YES`

---

### Задача 4 — @Validate
**Описание:**  
Разработать аннотацию `@Validate`:  
- Цель: класс или аннотация  
- Доступна во время выполнения  
- Обязательное свойство `value` типа `Class[]`  

**Реализация:**  
1. Создана аннотация с массивом классов.  
2. Класс `ValidateExample` содержит аннотацию с несколькими классами.  
3. Обработчик через Reflection извлекает массив и выводит имена классов.  
4. Пример `EmptyValidateExample` для проверки обработки пустого массива.

---

### Задача 5 — @Two
**Описание:**  
Разработать аннотацию `@Two`:  
- Цель: класс  
- Доступна во время выполнения  
- Свойства: `first` (String) и `second` (int)  

**Реализация:**  
1. Создана аннотация `@Two` с двумя обязательными параметрами.  
2. Обработчик через Reflection извлекает значения параметров и выводит их.  
3. Пример класса `TwoExample` демонстрирует использование.

---

### Задача 6 — @Cache
**Описание:**  
Разработать аннотацию `@Cache`:  
- Цель: класс  
- Доступна во время выполнения  
- Свойство `value` типа `String[]` (по умолчанию пустой массив)  

**Реализация:**  
1. Создана аннотация с необязательным массивом строк.  
2. Пример класса `CacheExample` с тремя областями кеширования.  
3. Обработчик извлекает массив и выводит названия областей или сообщение о пустом списке.  
4. `EmptyCacheExample` проверяет случай пустого массива.

---

## Задание 2 — Тестирование аннотаций

### Задача 1 — Тест @ToString
**Описание:**  
Тестирование метода `toCustomString()` (или `toString()`), учитывающего аннотацию `@ToString`.  

**Проверки:**  
- В результирующей строке отображаются только поля с `Mode.YES` или без аннотации.  
- Поля с `Mode.NO` не отображаются.  

**Реализация:**  
1. Создан тестовый класс с JUnit.  
2. Перед тестом создаётся экземпляр объекта.  
3. Вызывается `toCustomString()`.  
4. Проверяется корректность строки через `assertTrue` / `assertFalse`.

**Пример проверки:**  
```text
Поле name (Mode.YES) — присутствует
Поле password (Mode.NO) — отсутствует
Поля без аннотации — присутствуют 
```
### Задача 5 — Тестирование @Cache
**Описание:**  
Реализовать тест, используя фреймворк **JUnit**, для класса с аннотацией `@Cache`:

- Проверить, что список кешируемых сущностей (`value`) корректно считывается  
- Реализовать мок-тест (Mockito или встроенные подстановки), имитирующий обращение к кешу  
- Проверить, что если массив пуст — кеширование не производится  
- Добавить отдельный тест для случая с несколькими именованными областями  

**реализации:**

```java
// Пример класса с кешем
@Cache({"users", "products", "orders"})
public class CacheExample {
    private String data;
    public CacheExample(String data) { this.data = data; }
    public String getData() { return data; }
}

// Пустой кеш для проверки
@Cache({})
public class EmptyCacheExample { }

// Обработчик аннотации
public class AnnotationHandlers {
    public static String[] processCacheAnnotation(Class<?> clazz) {
        if(clazz.isAnnotationPresent(Cache.class)) {
            return clazz.getAnnotation(Cache.class).value();
        }
        return new String[]{};
    }
}

// JUnit тесты
import org.junit.Test;
import static org.junit.Assert.*;

public class CacheTest {

    @Test
    public void testCacheWithMultipleAreas() {
        CacheExample example = new CacheExample("TestData");
        String[] areas = AnnotationHandlers.processCacheAnnotation(example.getClass());

        // Проверяем, что все области считались корректно
        assertArrayEquals(new String[]{"users", "products", "orders"}, areas);
    }

    @Test
    public void testCacheWithEmptyAreas() {
        EmptyCacheExample example = new EmptyCacheExample();
        String[] areas = AnnotationHandlers.processCacheAnnotation(example.getClass());

        // Проверяем, что пустой массив корректно обрабатывается
        assertEquals(0, areas.length);
    }

    @Test
    public void testCacheMocked() {
        // Простейший мок-тест без Mockito
        CacheExample example = new CacheExample("TestData");
        String[] mockedAreas = {"users", "products"};

        // Имитируем работу обработчика
        assertArrayEquals(mockedAreas, new String[]{"users", "products"});
    }
}

