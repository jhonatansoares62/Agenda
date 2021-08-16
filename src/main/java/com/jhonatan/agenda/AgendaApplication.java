package com.jhonatan.agenda;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jhonatan.agenda.model.Consulta;
import com.jhonatan.agenda.model.Consultorio;
import com.jhonatan.agenda.model.Medico;
import com.jhonatan.agenda.model.Paciente;
import com.jhonatan.agenda.model.emums.EspecialidadeMedica;
import com.jhonatan.agenda.repositories.ConsultaRepository;
import com.jhonatan.agenda.repositories.ConsultorioRepository;
import com.jhonatan.agenda.repositories.MedicoRepository;
import com.jhonatan.agenda.repositories.PacienteRepository;

@SpringBootApplication
public class AgendaApplication implements CommandLineRunner {

	@Autowired
	private ConsultorioRepository consultorioRepository;

	@Autowired
	private MedicoRepository medicoRepository;

	@Autowired
	PacienteRepository pacienteRepository;

	@Autowired
	ConsultaRepository consultaRepository;

	public static void main(String[] args) {
		SpringApplication.run(AgendaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Consultorio consultorio1 = new Consultorio(1L, 1, "Consultorio 1");
		Consultorio consultorio2 = new Consultorio(2L, 2, "Consultorio 2");
		Consultorio consultorio3 = new Consultorio(3L, 3, "Consultorio 3");
		Consultorio consultorio4 = new Consultorio(4L, 4, "Consultorio 4");

		consultorioRepository.saveAll(Arrays.asList(consultorio1, consultorio2, consultorio3, consultorio4));

		Medico m1 = new Medico(1L, "Medico 1", LocalDate.of(1980, 3, 18), "90.264/SP",
				EspecialidadeMedica.ANESTEOLOGIA);
		Medico m2 = new Medico(2L, "Medico 2", LocalDate.of(1992, 04, 03), "80.356/SC",
				EspecialidadeMedica.CARDIOLOGIA);
		Medico m3 = new Medico(3L, "Medico 3", LocalDate.of(1979, 12, 10), "44.553/RS",
				EspecialidadeMedica.CIRURGIA_PEDIATRICA);
		Medico m4 = new Medico(4L, "Medico 4", LocalDate.of(1969, 02, 15), "54.877/MT",
				EspecialidadeMedica.CIRURGIA_CARDIACA);

		medicoRepository.saveAll(Arrays.asList(m1, m2, m3, m4));

		Paciente p1 = new Paciente(1L, "Paciente 1", "258.010.300-77");
		Paciente p2 = new Paciente(2L, "Paciente 2", "532.980.890-10");
		Paciente p3 = new Paciente(3L, "Paciente 3", "407.448.730-61");
		Paciente p4 = new Paciente(4L, "Paciente 4", "494.380.540-06");
		Paciente p5 = new Paciente(5L, "Paciente 5", "906.312.050-80");
		Paciente p6 = new Paciente(6L, "Paciente 6", "891.070.540-09");
		Paciente p7 = new Paciente(7L, "Paciente 7", "221.265.930-02");
		Paciente p8 = new Paciente(8L, "Paciente 8", "284.163.080-39");
		Paciente p9 = new Paciente(9L, "Paciente 9", "810.861.700-67");
		Paciente p10 = new Paciente(10L, "Paciente 10", "559.093.240-80");
		Paciente p11 = new Paciente(11L, "Paciente 11", "674.142.480-62");
		Paciente p12 = new Paciente(12L, "Paciente 12", "362.119.380-47");

		pacienteRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12));

		LocalDate d1 = LocalDate.of(2021, 06, 21);
		LocalDate d2 = LocalDate.of(2021, 06, 21);
		LocalDate d3 = LocalDate.of(2021, 8, 21);
		LocalDate d4 = LocalDate.of(2021, 05, 21);
		LocalDate d5 = LocalDate.of(2021, 9, 21);
		LocalDate d6 = LocalDate.of(2021, 04, 21);
		LocalDate d7 = LocalDate.of(2021, 10, 21);
		LocalDate d8 = LocalDate.of(2021, 03, 21);
		LocalDate d9 = LocalDate.of(2021, 11, 21);
		LocalDate d10 = LocalDate.of(2021, 02, 21);
		LocalDate d11 = LocalDate.of(2021, 12, 21);
		LocalDate d12 = LocalDate.of(2021, 01, 21);

		LocalTime t1 = LocalTime.of(06, 21);
		LocalTime t2 = LocalTime.of(06, 21);
		LocalTime t3 = LocalTime.of(8, 21);
		LocalTime t4 = LocalTime.of(05, 21);
		LocalTime t5 = LocalTime.of(9, 21);
		LocalTime t6 = LocalTime.of(04, 21);
		LocalTime t7 = LocalTime.of(20, 21);
		LocalTime t8 = LocalTime.of(03, 21);
		LocalTime t9 = LocalTime.of(11, 21);
		LocalTime t10 = LocalTime.of(02, 21);
		LocalTime t11 = LocalTime.of(12, 21);
		LocalTime t12 = LocalTime.of(01, 21);
		
		DateTimeFormatter fD = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter fH = DateTimeFormatter.ofPattern("HH:MM");

		Consulta cons1 = new Consulta(1L, m1, p1, consultorio4, d1, t1);
		Consulta cons2 = new Consulta(2L, m3, p4, consultorio2, d2, t2);
		Consulta cons3 = new Consulta(3L, m2, p3, consultorio1, d3, t3);
		Consulta cons4 = new Consulta(4L, m2, p4, consultorio3, d4, t4);
		Consulta cons5 = new Consulta(5L, m3, p1, consultorio3, d5, t5);
		Consulta cons6 = new Consulta(6L, m1, p5, consultorio3, d6, t6);
		Consulta cons7 = new Consulta(7L, m2, p1, consultorio3, d7, t7);
		Consulta cons8 = new Consulta(8L, m4, p7, consultorio3, d8, t8);
		Consulta cons9 = new Consulta(9L, m2, p9, consultorio3, d9, t9);
		Consulta cons10 = new Consulta(10L, m1, p10, consultorio3, d10, t10);
		Consulta cons11 = new Consulta(11L, m3, p11, consultorio3, d11, t11);
		Consulta cons12 = new Consulta(12L, m4, p9, consultorio3, d12, t12);

		consultaRepository.saveAll(
				Arrays.asList(cons1, cons2, cons3, cons4, cons5, cons6, cons7, cons8, cons9, cons10, cons11, cons12));

	}

}
