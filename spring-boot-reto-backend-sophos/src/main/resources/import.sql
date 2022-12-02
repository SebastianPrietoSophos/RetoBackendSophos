insert into tests(nombre, description) values ('Test 1', 'aaaa bbbb ccc ddd');
insert into tests(nombre, description) values ('Test 2', 'xxxx yyyy www zzz');
insert into tests(nombre, description) values ('Test 3', 'jjjj mmmm nnn lll');

insert into affiliates(nombre, age, mail) values ('Jose Lopera', 23, 'jolo@yyy.com');
insert into affiliates(nombre, age, mail) values ('Maria Lopez', 45, 'malo@yyy.com');
insert into affiliates(nombre, age, mail) values ('Raul Gomez', 12, 'rago@yyy.com');

INSERT into appointments(date_a, hour_a, id_test, id_affiliate) values (TO_DATE('10-12-2012','dd-MM-yyyy'), TO_DATE('08:12','HH24:MI'), 2, 3);
INSERT into appointments(date_a, hour_a, id_test, id_affiliate) values (TO_DATE('25-12-2012','dd-MM-yyyy'), TO_DATE('21:12','HH24:MI'), 3, 1);
INSERT into appointments(date_a, hour_a, id_test, id_affiliate) values (TO_DATE('25-12-2022','dd-MM-yyyy'), TO_DATE('12:12','HH24:MI'), 2, 2);
