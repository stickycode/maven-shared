package org.apache.maven.shared.filtering;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import java.io.File;
import java.util.List;

import org.apache.maven.execution.MavenSession;
import org.apache.maven.project.MavenProject;
import org.apache.maven.shared.utils.io.FileUtils;

/**
 * @author Olivier Lamy
 */
public interface MavenFileFilter
    extends DefaultFilterInfo
{

    /**
     * Will copy a file with some filtering using defaultFilterWrappers.
     *
     * @param from file to copy/filter
     * @param to destination file
     * @param filtering enable or not filering
     * @param mavenProject the mavenproject
     * @param filters {@link List} of String which are path to a Property file
     * @throws MavenFilteringException
     * @see #getDefaultFilterWrappers(MavenProject, List, boolean, MavenSession)
     */
    void copyFile( File from, final File to, boolean filtering, MavenProject mavenProject, List<String> filters,
                   boolean escapedBackslashesInFilePath, String encoding, MavenSession mavenSession )
        throws MavenFilteringException;

    /**
     * @param mavenFileFilterRequest
     * @throws MavenFilteringException
     * @since 1.0-beta-3
     */
    void copyFile( MavenFileFilterRequest mavenFileFilterRequest )
        throws MavenFilteringException;

    /**
     * @param from
     * @param to
     * @param filtering
     * @param filterWrappers {@link List} of FileUtils.FilterWrapper
     * @throws MavenFilteringException
     */
    void copyFile( File from, final File to, boolean filtering, List<FileUtils.FilterWrapper> filterWrappers,
                   String encoding )
        throws MavenFilteringException;

    /**
     * @param from
     * @param to
     * @param filtering
     * @param filterWrappers
     * @param encoding
     * @param overwrite
     * @throws MavenFilteringException
     * @since 1.0-beta-2
     */
    void copyFile( File from, final File to, boolean filtering, List<FileUtils.FilterWrapper> filterWrappers,
                   String encoding, boolean overwrite )
        throws MavenFilteringException;
}
