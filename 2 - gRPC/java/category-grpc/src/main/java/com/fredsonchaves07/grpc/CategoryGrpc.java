package com.fredsonchaves07.grpc;

import com.fredsonchaves07.Category;
import com.fredsonchaves07.CategoryResponse;
import com.fredsonchaves07.CategoryServiceGrpc;
import com.fredsonchaves07.CreateCategoryRequest;
import com.fredsonchaves07.service.CategoryService;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GrpcService
public class CategoryGrpc extends CategoryServiceGrpc.CategoryServiceImplBase {

    @Autowired
    private CategoryService service;

    @Override
    public void createCategory(CreateCategoryRequest categoryRequest, StreamObserver<CategoryResponse> responseObserver) {
        responseObserver.onNext(service.create(categoryRequest));
        responseObserver.onCompleted();
    }
}
