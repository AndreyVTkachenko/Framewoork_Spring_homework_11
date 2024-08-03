package ru.gb.service;

import lombok.RequiredArgsConstructor;
import org.slf4j.event.Level;
import org.springframework.stereotype.Service;
import ru.gb.recover.Recover;
import ru.gb.logging.Logging;
import ru.gb.timer.Timer;
import ru.gb.model.Employee;
import ru.gb.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Timer(level = Level.TRACE)
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Logging(level = Level.WARN)
    @Recover(level = Level.WARN)
    public Optional<Employee> getById(Long id) {
        return employeeRepository.findById(id);
    }

    @Logging(level = Level.WARN)
    @Recover(level = Level.WARN)
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }
}
