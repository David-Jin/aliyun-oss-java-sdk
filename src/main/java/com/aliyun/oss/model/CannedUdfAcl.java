/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.aliyun.oss.model;

/**
 * UDF访问权限。
 *
 */
public enum CannedUdfAcl {
    
    /**
     * 只有所有者具有访问权限，其他用无权访问。UDF默认权限。
     */
    Private("private"),

    /**
     * 所有者和其他用户均有访问权限。不推荐使用。
     */
    Public("public");


    private String cannedAclString;
    
    private CannedUdfAcl(String cannedAclString){
        this.cannedAclString = cannedAclString;
    }

    @Override
    public String toString() {
        return this.cannedAclString;
    }
    
    public static CannedUdfAcl parse(String acl) {
        for(CannedUdfAcl cacl : CannedUdfAcl.values()) {
            if (cacl.toString().equals(acl)) {
                return cacl;
            }
        }
        
        throw new IllegalArgumentException("Unable to parse the provided acl " + acl);
    }
}
