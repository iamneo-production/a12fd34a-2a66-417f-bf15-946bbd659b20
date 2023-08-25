package com.virtusa.repository;

import com.virtusa.entity.FileStorage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentStorageRepo extends JpaRepository<FileStorage, String> {
}
