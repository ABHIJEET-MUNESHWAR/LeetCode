# In-Memory Rate Limiter Implementation

### Problem Statement

Design and implement an **in-memory rate limiter**.

Build a component that limits how many requests a client can make within a given time window.

The API should support:

```text
allow(clientId) → boolean
```

### Example

```text
limit = 3 requests
window = 10 seconds

allow("user1") → true
allow("user1") → true
allow("user1") → true
allow("user1") → false
```

After the window expires, the client should be allowed to make requests again.

---

## Requirements

1. Each `clientId` has its own rate limit.

2. The implementation should support many clients.

3. Expired requests should not unnecessarily consume memory.

4. `allow()` should be efficient.

5. Assume the component can eventually be called concurrently by multiple threads.

6. The candidate should write **production-quality code with tests**.

### Interface

```java
interface RateLimiter {
    boolean allow(String clientId);
}
```

### Expected behavior

For a limit of **3 requests per 10 seconds**, the first three requests from a client within the 10-second window should return `true`, while the fourth should return `false`. Once the relevant requests fall outside the window, new requests should again be allowed.
