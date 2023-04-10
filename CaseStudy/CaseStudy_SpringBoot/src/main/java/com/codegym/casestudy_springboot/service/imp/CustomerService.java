package com.codegym.casestudy_springboot.service.imp;

import com.codegym.casestudy_springboot.model.customer.Customer;
import com.codegym.casestudy_springboot.repository.ICustomerRepository;
import com.codegym.casestudy_springboot.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    ICustomerRepository iCustomerRepository;

    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public Customer findById(int id) {
        return iCustomerRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(int id) {
        iCustomerRepository.deleteById(id);
    }

    @Override
    public Page<Customer> paqing(Pageable pageable) {
        return iCustomerRepository.findAll(pageable);
    }

//    @Override
//    public Page<Customer> paginationByName(String name, Pageable pageable) {
//        return iCustomerRepository.findByNameContaining(name, pageable);
//    }

//    @Override
//    public Page<Customer> paginationByIdCard(String idCard, Pageable pageable) {
//        return iCustomerRepository.findByIdCardContaining(idCard, pageable);
//    }
//
//    @Override
//    public Page<Customer> paginationByCustomerType_Id(Integer id, Pageable pageable) {
//        return iCustomerRepository.findByCustomerType_Id(id, pageable);
//    }
//
    @Override
    public Page<Customer> paginationByNameAndIdCard(String name, String idCard, Pageable pageable) {
        return iCustomerRepository.findByNameContainingAndIdCardContaining(name, idCard, pageable);
    }
//
//    @Override
//    public Page<Customer> paginationByNameAndCustomerType_Id(String name, Integer id, Pageable pageable) {
//        return iCustomerRepository.findByNameContainingAndCustomerType_Id(name, id, pageable);
//    }
//
//    @Override
//    public Page<Customer> paginationByIdCardAndCustomerType_Id(String idCard, Integer id, Pageable pageable) {
//        return iCustomerRepository.findByIdCardContainingAndCustomerType_Id(idCard, id, pageable);
//    }
//
    @Override
    public Page<Customer> paginationByNameAndIdCardAndCustomerType_Id(String name, String idCard, Integer id, Pageable pageable) {
        return iCustomerRepository.findByNameContainingAndIdCardContainingAndCustomerType_Id(name, idCard, id, pageable);
    }

    @Override
    public Page<Customer> search(String name, String idCard, String customerTypeId, Pageable pageable) {
        return iCustomerRepository.search(name,idCard,customerTypeId,pageable);
    }
}
