# WSO2 Enterprise Micro Integrator Performance Test Results

During each release, we execute various automated performance test scenarios and publish the results.

| Test Scenarios | Description |
| --- | --- |
| DirectProxy |  |
| CBRProxy |  |

Our test client is [Apache JMeter](https://jmeter.apache.org/index.html). We test each scenario for a fixed duration of
time. We split the test results into warmup and measurement parts and use the measurement part to compute the
performance metrics.

Test scenarios use a [Netty](https://netty.io/) based back-end service which echoes back any request
posted to it after a specified period of time.

We run the performance tests under different numbers of concurrent users, message sizes (payloads) and back-end service
delays.

The main performance metrics:

1. **Throughput**: The number of requests that the WSO2 Enterprise Integrator processes during a specific time interval (e.g. per second).
2. **Response Time**: The end-to-end latency for an operation of invoking a service in WSO2 Enterprise  Integrator. The complete distribution of response times was recorded.

In addition to the above metrics, we measure the load average and several memory-related metrics.

The following are the test parameters.

| Test Parameter | Description | Values |
| --- | --- | --- |
| Scenario Name | The name of the test scenario. | Refer to the above table. |
| Heap Size | The amount of memory allocated to the application | 512M |
| Concurrent Users | The number of users accessing the application at the same time. | 100, 200 |
| Message Size (Bytes) | The request payload size in Bytes. | 500 |
| Back-end Delay (ms) | The delay added by the back-end service. | 0 |

The duration of each test is **120 seconds**. The warm-up period is **60 seconds**.
The measurement results are collected after the warm-up period.

A [**t3.small** Amazon EC2 instance](https://aws.amazon.com/ec2/instance-types/) was used to install EI.

The following are the measurements collected from each performance test conducted for a given combination of
test parameters.

| Measurement | Description |
| --- | --- |
| Error % | Percentage of requests with errors |
| Average Response Time (ms) | The average response time of a set of results |
| Standard Deviation of Response Time (ms) | The “Standard Deviation” of the response time. |
| 99th Percentile of Response Time (ms) | 99% of the requests took no more than this time. The remaining samples took at least as long as this |
| Throughput (Requests/sec) | The throughput measured in requests per second. |
| Average Memory Footprint After Full GC (M) | The average memory consumed by the application after a full garbage collection event. |

The following is the summary of performance test results collected for the measurement period.

|  Scenario Name | Heap Size | Concurrent Users | Message Size (Bytes) | Back-end Service Delay (ms) | Error % | Throughput (Requests/sec) | Average Response Time (ms) | Standard Deviation of Response Time (ms) | 99th Percentile of Response Time (ms) | WSO2 Enterprise Micro Integrator GC Throughput (%) | Average WSO2 Enterprise Micro Integrator Memory Footprint After Full GC (M) |
|---|---:|---:|---:|---:|---:|---:|---:|---:|---:|---:|---:|
|  CBRProxy | 512M | 100 | 500 | 0 | 0 | 608.49 | 163.64 | 72.86 | 391 | 97.91 | 27.843 |
|  CBRProxy | 512M | 200 | 500 | 0 | 0 | 624.9 | 318.33 | 129.74 | 699 | 97.47 | 27.81 |
|  DirectProxy | 512M | 100 | 500 | 0 | 0 | 776.99 | 128.47 | 61.77 | 301 | 98.08 | 27.757 |
|  DirectProxy | 512M | 200 | 500 | 0 | 0 | 825.5 | 241.63 | 99.47 | 505 | 97.21 | 27.941 |
