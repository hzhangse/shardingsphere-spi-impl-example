/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.shardingsphere.example.transaction.base.seata.spring.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import io.shardingsphere.example.common.jpa.service.JpaOptService;

@Component
public class NoSeatsTransactionalService {
    private final JpaOptService jpaOptService;
    
    @Autowired
    public NoSeatsTransactionalService(final JpaOptService jpaOptService) {
        this.jpaOptService = jpaOptService;
    }
    
    /**
     * process success.
     */
   // @ShardingTransactionType(TransactionType.BASE)
    @Transactional
    public void processSuccess() {
        jpaOptService.processSuccess();
    }
    
    /**
     * process failure.
     */
   // @ShardingTransactionType(TransactionType.BASE)
    @Transactional
    public void processFailure() {
        jpaOptService.processFailure();
    }
    
    public void printData() {
        jpaOptService.printData();
    }
}
