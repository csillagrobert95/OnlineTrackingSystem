package com.tracking.adminoperationssoap.repository;

import com.tracking.adminoperationssoap.dao.Package;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Robi on 12/29/2018.
 */
@Repository
public interface PackageRepository extends JpaRepository<Package, Integer> {
}
