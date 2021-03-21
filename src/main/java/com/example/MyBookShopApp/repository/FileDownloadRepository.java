package com.example.MyBookShopApp.repository;

import com.example.MyBookShopApp.data.FileDownload;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileDownloadRepository extends JpaRepository<FileDownload, Integer> {
}
