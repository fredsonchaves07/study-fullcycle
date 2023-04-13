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

    public void create(CreateCategoryRequest categoryRequest, StreamObserver<CategoryResponse> responseObserver) {
        com.fredsonchaves07.entity.Category category = new com.fredsonchaves07.entity.Category(
                categoryRequest.getName(), categoryRequest.getDescription()
        );
        Category categoryGrpc = Category.newBuilder()
                .setId(category.getId().toString())
                .setName(category.getName())
                .setDescription(category.getDescription())
                .build();
        CategoryResponse categoryResponse = CategoryResponse.newBuilder().setCategory(categoryGrpc).build();
        responseObserver.onNext(categoryResponse);
        responseObserver.onCompleted();
    }
}