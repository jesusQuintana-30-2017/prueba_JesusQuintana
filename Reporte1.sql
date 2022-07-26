DECLARE
  CURSOR cventas(fecha_inicio IN VARCHAR2,fecha_final IN VARCHAR2)
  IS  SELECT producto.descripcion,FECHA, SUM(TOTAL)
  FROM VENTA INNER JOIN producto ON VENTA.producto_id = producto.ID 
  WHERE FECHA >= fecha_inicio AND FECHA <= fecha_final
  GROUP BY producto.descripcion,FECHA;
  producto VARCHAR2(150;
  fecha  VARCHAR2(10);
  total DECIMAL(50,2);
BEGIN
  OPEN cventas;
  FETCH cventas INTO producto,fecha,total;
  CLOSE cventas;
END;