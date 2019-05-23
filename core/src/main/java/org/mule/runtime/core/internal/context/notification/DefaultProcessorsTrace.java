/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.runtime.core.internal.context.notification;

import static java.util.Collections.unmodifiableList;

import org.mule.runtime.core.api.context.notification.ProcessorsTrace;

import java.util.ArrayList;
import java.util.List;

/**
 * Keeps context information about the message processors that were executed as part of the processing of an event.
 */
public class DefaultProcessorsTrace implements ProcessorsTrace {

  private static final long serialVersionUID = 5327053121687733907L;

  private final List<String> executedProcessors = new ArrayList<>();

  /**
   * Adds a message processor path to the list of processors that were executed as part of the processing of this event.
   *
   * @param processorPath the path to mask as executed.
   */
  public synchronized void addExecutedProcessors(String processorPath) {
    if (!executedProcessors.contains(processorPath)) {
      executedProcessors.add(processorPath);
    }
  }

  @Override
  public synchronized List<String> getExecutedProcessors() {
    return unmodifiableList(executedProcessors);
  }

}
