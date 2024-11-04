SELECT Productos.Nombre_prod, Proveedores.Nombre_prov FROM Productos JOIN Proveedores ON Productos.Cod_prov = Proveedores.Cod_prov WHERE Productos.precio > 100 ORDER BY Productos.precio DESC
SELECT Proveedores.Nombre_prov, Proveedores.Telefono FROM Productos JOIN Proveedores ON Productos.Cod_prov = Proveedores.Cod_prov WHERE Productos.Nombre_prod LIKE '%Producto Uno%'
SELECT Nombre_prod FROM Productos WHERE stock < 20
UPDATE Productos SET precio = precio * 0.95 WHERE Cod_prov IN (SELECT Cod_prov FROM Proveedores WHERE Bonifica = 5)
SELECT Proveedores.Nombre_prov, COUNT(Productos.Cod_prod), AVG(Productos.precio) FROM Proveedores LEFT JOIN Productos ON Proveedores.Cod_prov = Productos.Cod_prov GROUP BY Proveedores.Nombre_prov
SELECT Proveedores.Nombre_prov, Proveedores.Direccion, Proveedores.Telefono FROM Proveedores WHERE Proveedores.Cod_prov = (SELECT Cod_prov FROM Productos ORDER BY stock DESC limit 1)
