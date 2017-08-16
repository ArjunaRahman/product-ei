/*
 * Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.ei.tools.converter.common.ballerinahelper;

import org.wso2.ei.tools.converter.common.builder.BallerinaASTModelBuilder;
import org.wso2.ei.tools.converter.common.util.Constant;

import java.util.Map;

/**
 * Represent ballerina annotations
 */
public class Annotation {

    public static void createServiceAnnotation(BallerinaASTModelBuilder ballerinaASTModelBuilder,
            Map<String, Object> parameters) {
        ballerinaASTModelBuilder
                .createAnnotationAttachment(Constant.BLANG_HTTP, Constant.BLANG_CONFIG);
        ballerinaASTModelBuilder.createAnnotationAttributeValue(Constant.BLANG_BASEPATH,
                (String) parameters.get(Constant.BASEPATH_VALUE));
        ballerinaASTModelBuilder.addAnnotationAttachment(1); //attributesCount is never used
    }

    public static void createResourceAnnotation(BallerinaASTModelBuilder ballerinaASTModelBuilder,
            Map<String, Object> parameters) {
        ballerinaASTModelBuilder
                .createAnnotationAttachment(Constant.BLANG_HTTP, Constant.BLANG_RESOURCE_CONFIG);
        ballerinaASTModelBuilder.createAnnotationAttributeArrayType(Constant.BLANG_METHODS, (String[]) parameters.get
                (Constant.METHOD_NAME));
        ballerinaASTModelBuilder.addAnnotationAttachment(1); //attributesCount is never used
    }

}
