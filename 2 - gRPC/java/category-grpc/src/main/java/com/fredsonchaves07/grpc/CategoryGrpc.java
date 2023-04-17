package com.fredsonchaves07.grpc;

import com.fredsonchaves07.*;
import com.fredsonchaves07.service.CategoryService;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GrpcService
public class CategoryGrpc extends CategoryServiceGrpc.CategoryServiceImplBase {

    @Autowired
    private CategoryService service;

    @Override
    public void createCategory(CreateCategoryRequest categoryRequest, StreamObserver<Category> responseObserver) {
        responseObserver.onNext(service.create(categoryRequest));
        responseObserver.onCompleted();
    }

    @Override
    public void listCategory(blank blank, StreamObserver<CategoryList> responseObserver) {
        responseObserver.onNext(service.list());
        responseObserver.onCompleted();
    }

    @Override
    public void getCategory(CategoryGetRequest request, StreamObserver<Category> responseObserver) {
        responseObserver.onNext(service.get(request.getId()));
        responseObserver.onCompleted();
    }
}
