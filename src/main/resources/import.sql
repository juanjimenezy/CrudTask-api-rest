INSERT INTO `task`.`celulas` (`id`, `nombre`, `product_owner`, `proyecto`) VALUES (1, 'RECAUDOS', 'KERALTY', 'RECAUDOS');

INSERT INTO `task`.`roles` (`id`, `descripcion`, `nombre_rol`) VALUES (1, 'LIDER TECNICO', 'LIDER_TECNICO');
INSERT INTO `task`.`roles` (`id`, `descripcion`, `nombre_rol`) VALUES (2, 'DESARROLLADOR', 'DESARROLLADOR');

INSERT INTO `task`.`personas` (`id`, `email`, `nick_name`, `nombre`, `numero_identificacion`, `id_rol_id`) VALUES (1, 'jrjimenez@indracompany.com', 'JUAN', 'JUAN JIMENEZ', '9999999', 2);
INSERT INTO `task`.`personas` (`id`, `email`, `nick_name`, `nombre`, `numero_identificacion`, `id_rol_id`) VALUES (2, 'dsrodriguezl@indracompany.com', 'BENJAMIN', 'BENJAMIN NIETO', '9999999', 2);
INSERT INTO `task`.`personas` (`id`, `email`, `nick_name`, `nombre`, `numero_identificacion`, `id_rol_id`) VALUES (3, 'ctorresc@indracompany.com', 'DANIELA', 'DANIELA LEON', '9999999', 2);

INSERT INTO `task`.`tareas` (`id`, `estado`, `nombre`, `porcentaje`, `sprint`, `celula_id`, `persona_id`) VALUES (1, 'NUEVA', 'HU_FCRE_03', 0, 5, 1, 1);

INSERT INTO `task`.`sub_tareas` (`id`, `horas`, `nombre`, `estado`, `tarea_id`, `porcentaje`) VALUES (1, 9, 'ANALISIS', 'TERMINADO', 1, 100);
INSERT INTO `task`.`sub_tareas` (`id`, `horas`, `nombre`, `estado`, `tarea_id`, `porcentaje`) VALUES (2, 9, 'DISEÑO TECNICO', 'TERMINADO', 1, 100);
INSERT INTO `task`.`sub_tareas` (`id`, `horas`, `nombre`, `estado`, `tarea_id`, `porcentaje`) VALUES (3, 18, 'DESARROLLO', 'EN PROCESO', 1, 70);
INSERT INTO `task`.`sub_tareas` (`id`, `horas`, `nombre`, `estado`, `tarea_id`, `porcentaje`) VALUES (4, 9, 'PRUEBAS UNITARIAS', 'PENDIENTE', 1, 1);



UPDATE `task`.`sq_id_celulas` SET `next_val` = 2 WHERE `next_val` = 1 LIMIT 1;
UPDATE `task`.`sq_id_roles` SET `next_val` = 3 WHERE `next_val` = 1 LIMIT 1;
UPDATE `task`.`sq_id_personas` SET `next_val` = 5 WHERE `next_val` = 1 LIMIT 1;
UPDATE `task`.`sq_id_tareas` SET `next_val` = 2 WHERE `next_val` = 1 LIMIT 1;
UPDATE `task`.`sq_id_sub_tareas` SET `next_val` = 5 WHERE `next_val` = 1 LIMIT 1;